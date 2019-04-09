package com.gaomt.yummy.service.order;

import com.gaomt.yummy.constant.*;
import com.gaomt.yummy.domain.Orders;
import com.gaomt.yummy.repository.OrderDAO;
import com.gaomt.yummy.service.commodity.CommodityService;
import com.gaomt.yummy.service.delivery.DeliveryService;
import com.gaomt.yummy.service.record.RecordService;
import com.gaomt.yummy.service.resaurant.ResaurantService;
import com.gaomt.yummy.service.user.UserAccessService;
import com.gaomt.yummy.service.user.UserModifyService;
import com.gaomt.yummy.utils.DateUtils;
import com.gaomt.yummy.utils.OrderProperties;
import com.gaomt.yummy.utils.quartz.CancelOrderJob;
import com.gaomt.yummy.utils.quartz.ConfirmOrderJob;
import com.gaomt.yummy.utils.quartz.QuartzCronDateUtils;
import com.gaomt.yummy.utils.quartz.QuartzJobManager;
import com.gaomt.yummy.vo.OrderCommVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author： MengtingGao
 * @Date： Create in 17:26 2019/2/26
 * @Description:
 */
@Service
public class OrderStateServiceImpl implements OrderStateService {

  @Autowired
  private OrderDAO orderDAO;
  @Autowired
  private UserAccessService userAccessService;
  @Autowired
  private UserModifyService userModifyService;
  @Autowired
  private CommodityService commodityService;
  @Autowired
  private QuartzJobManager quartzJobManager;
  @Autowired
  private RecordService recordService;
  @Autowired
  private OrderCommService orderCommService;
  @Autowired
  private OrderProperties orderProperties;
  @Autowired
  private ResaurantService resaurantService;
  @Autowired
  private DeliveryService deliveryService;

  @Override
  public void receiveOrder(int orderID) {
    changeState(orderID, OrderState.UNACCEPTED, OrderState.ACCEPTED);
    deliveryService.addDelivery(orderID, DeliveryType.RECEIVE);
  }

  @Override
  public void deliveryOrder(int orderID) {
    changeState(orderID, OrderState.ACCEPTED, OrderState.DELIVERY);
    deliveryService.addDelivery(orderID, DeliveryType.DELIVERY);
  }

  @Override
  public void arriveOrder(int orderID) {
    changeState(orderID, OrderState.DELIVERY, OrderState.ARRIVE);
    deliveryService.addDelivery(orderID, DeliveryType.ARRIVE);
    //任务名称
    String name = String.valueOf(orderID);
    //任务组名称
    String groupName = "confirmTask";
    //cron表达式
    String cron = QuartzCronDateUtils.getCron(DateUtils.getDateAfterMinutes(new Date(), orderProperties.getConfirmMinutes()));
    //需要给任务携带的参数
    Map<String, Object> map = new HashMap<>();
    map.put("orderID", orderID);
    quartzJobManager.addJob(ConfirmOrderJob.class, name, groupName, cron, map);
  }

  @Override
  public void cancelOrder(int orderID, Date date) {
    //任务名称
    String name = String.valueOf(orderID);
    //任务组名称
    String groupName = "cancelTask";
    //cron表达式
    String cron = QuartzCronDateUtils.getCron(date);
    //需要给任务携带的参数
    Map<String, Object> map = new HashMap<>();
    map.put("orderID", orderID);
    quartzJobManager.addJob(CancelOrderJob.class, name, groupName, cron, map);
  }

  @Override
  public void cancelOrder(int orderID) {
    if (orderDAO.findById(orderID).isPresent()) {
      Orders orders = orderDAO.findById(orderID).get();
      String oldState = orders.getState();
      if (OrderState.valueOf(oldState) == OrderState.UNPAID) {
        orders.setState(OrderState.CANCEL.toString());
        orderDAO.save(orders);
        recordService.addRecord(RecordType.CANCEL, new Timestamp(new Date().getTime()), orders.getAmount(), orders.getResID(), orders.getUserID(), orders.getOrderID());
        returnCounts(orderCommService.getOrderCommsByOrderID(orderID));
      }
    }
  }

  @Override
  public PayResult payForOrder(int userID, int orderID) {
    if (orderDAO.findById(orderID).isPresent()) {
      Orders orders = orderDAO.findById(orderID).get();
      if (OrderState.valueOf(orders.getState()) == OrderState.UNPAID) {
        quartzJobManager.deleteJob(String.valueOf(orderID), "cancelTask");
        orders.setState(OrderState.UNACCEPTED.toString());
        orderDAO.save(orders);
        double amount = orders.getAmount();
        recordService.addRecord(RecordType.PAY, new Timestamp(new Date().getTime()), amount, orders.getResID(), userID, orders.getOrderID());
        return userAccessService.pay(userID, amount);
      }
      else return PayResult.FAIL;
    }
    return PayResult.FAIL;
  }

  @Override
  public CommonResult unsubOrder(int userID, int orderID) {
    double amount;
    if (orderDAO.findById(orderID).isPresent()) {
      Orders orders = orderDAO.findById(orderID).get();
      switch (OrderState.valueOf(orders.getState())) {
        case CANCEL:
        case FINISH:
        case ARRIVE:
        case UNSUB:
          return CommonResult.FAIL;
        default:
          quartzJobManager.deleteJob(String.valueOf(orderID), "cancelTask");
          amount = orders.getAmount();
          double discount = getAmountDiscountUnsub(OrderState.valueOf(orders.getState()));
          orders.setState(OrderState.UNSUB.toString());
          orderDAO.save(orders);
          if (discount != 0) {
            userAccessService.returnMoney(userID, amount * discount);
            recordService.addRecord(RecordType.UNSUB, new Timestamp(new Date().getTime()), amount * discount, orders.getResID(), userID, orders.getOrderID());
            returnCounts(orderCommService.getOrderCommsByOrderID(orderID));
          }
          break;
      }
      return CommonResult.SUCCESS;
    }
    else {
      return CommonResult.FAIL;
    }
  }

  @Override
  public void confirmDelivery(int orderID) {
    if (orderDAO.findById(orderID).isPresent()) {
      Orders orders = orderDAO.findById(orderID).get();
      OrderState state = OrderState.valueOf(orders.getState());
      if (isConfirmDelivery(state)) {
        orders.setState(OrderState.FINISH.toString());
        recordService.addRecord(RecordType.FINISH, new Timestamp(new Date().getTime()), orders.getAmount(), orders.getResID(), orders.getUserID(), orderID);
        orderDAO.save(orders);
        resaurantService.earn(orders.getResID(), orders.getAmount());
        userModifyService.addUserCount(orders.getUserID());
      }
    }
  }

  @Override
  public OrderState getStateByID(int orderID) {
    if (orderDAO.findById(orderID).isPresent()) {
      Orders orders = orderDAO.findById(orderID).get();
      return OrderState.valueOf(orders.getState());
    }
    else return null;
  }

  private void returnCounts(ArrayList<OrderCommVO> orderCommVOS) {
    for (OrderCommVO orderCommVO: orderCommVOS) {
      int commID = orderCommVO.getCommID();
      commodityService.addCount(commID, orderCommVO.getCount());
    }
  }

  private double getAmountDiscountUnsub(OrderState state){
    switch (state) {
      case UNACCEPTED:
        return 1.0;
      case ACCEPTED:
        return 0.8;
      case DELIVERY:
        return 0.5;
      default:
        return 0;
    }
  }

  private boolean isConfirmDelivery(OrderState state) {
    switch (state) {
      case UNPAID:
      case FINISH:
      case UNSUB:
      case CANCEL:
        return false;
      default:
        return true;
    }
  }

  private void changeState(int orderID, OrderState triggerState, OrderState state) {
    if (orderDAO.findById(orderID).isPresent()) {
      Orders orders = orderDAO.findById(orderID).get();
      if (OrderState.valueOf(orders.getState()) == triggerState) {
        orders.setState(state.toString());
        orderDAO.save(orders);
      }
    }
  }

}
