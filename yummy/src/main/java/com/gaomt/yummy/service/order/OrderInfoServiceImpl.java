package com.gaomt.yummy.service.order;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.constant.OrderState;
import com.gaomt.yummy.constant.RecordType;
import com.gaomt.yummy.domain.Orders;
import com.gaomt.yummy.repository.OrderDAO;
import com.gaomt.yummy.service.commodity.CommodityService;
import com.gaomt.yummy.service.record.RecordService;
import com.gaomt.yummy.service.resaurant.ResaurantService;
import com.gaomt.yummy.service.user.UserInfoService;
import com.gaomt.yummy.utils.DateUtils;
import com.gaomt.yummy.utils.OrderProperties;
import com.gaomt.yummy.vo.OrderCommVO;
import com.gaomt.yummy.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:11 2019/2/26
 * @Description:
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

  @Autowired
  private OrderDAO orderDAO;
  @Autowired
  private OrderCommService orderCommService;
  @Autowired
  private OrderStateService orderStateService;
  @Autowired
  private UserInfoService userInfoService;
  @Autowired
  private ResaurantService resaurantService;
  @Autowired
  private RecordService recordService;
  @Autowired
  private CommodityService commodityService;
  @Autowired
  private OrderProperties orderProperties;

  @Override
  public int addOrder(int userID, int resID, String number, String address, Timestamp arrive, double amount, ArrayList<OrderCommVO> orderCommVOs) {
    if (reduceCounts(orderCommVOs) == CommonResult.FAIL) {
      return -1;
    }
    Orders orders = new Orders();
    orders.setAddress(address);
    orders.setAmount(amount);
    orders.setArrive(arrive);
    orders.setNumbers(number);
    orders.setResID(resID);
    orders.setState(OrderState.UNPAID.toString());
    orders.setUserID(userID);
    orders.setTime(new Timestamp(new Date().getTime()));
    orderDAO.save(orders);
    orderCommService.addOrderCommsByVOs(orderCommVOs, orders.getOrderID());
    recordService.addRecord(RecordType.ORDER, new Timestamp(new Date().getTime()), amount, resID, userID, orders.getOrderID());
    orderStateService.cancelOrder(orders.getOrderID(), DateUtils.getDateAfterMinutes(new Date(), orderProperties.getCancelMinutes()));
    return orders.getOrderID();
  }

  @Override
  public OrderVO getOrderInfoByID(int orderID) {
    if (orderDAO.findById(orderID).isPresent()) {
      Orders orders = orderDAO.findById(orderID).get();
      OrderVO orderVO = new OrderVO();
      String userName = userInfoService.getUserNameByID(orders.getUserID());
      String resName = resaurantService.getNameByID(orders.getResID());
      orderVO.initByOrder(orders, userName, resName);
      return orderVO;
    }
    else return null;
  }

  @Override
  public ArrayList<OrderVO> getOrdersByUser(int userID) {
    return getOrdersByType(userID, true);
  }

  @Override
  public ArrayList<OrderVO> getOrdersByRes(int resID) {
    return getOrdersByType(resID, false);
  }

  @Override
  public double getAmountByID(int orderID) {
    if (orderDAO.findById(orderID).isPresent()) {
      Orders orders = orderDAO.findById(orderID).get();
      return orders.getAmount();
    }
    else return 0;
  }

  private ArrayList<OrderVO> getOrdersByType(int ID, boolean isUserNotRes) {
    ArrayList<OrderVO> orderVOS = new ArrayList<>();
    List<Orders> orders;
    OrderVO orderVO;

    if (isUserNotRes) orders = orderDAO.findOrdersByUserID(ID);
    else orders = orderDAO.findOrdersByResID(ID);

    for (Orders order: orders) {
      orderVO = new OrderVO();
      String userName = userInfoService.getUserNameByID(order.getUserID());
      String resName = resaurantService.getNameByID(order.getResID());
      orderVO.initByOrder(order, userName, resName);
      orderVOS.add(orderVO);
    }
    return orderVOS;
  }

  private CommonResult reduceCounts(ArrayList<OrderCommVO> orderCommVOS) {
    for (OrderCommVO orderCommVO: orderCommVOS) {
      int commID = orderCommVO.getCommID();
      if (commodityService.reduceCount(commID, orderCommVO.getCount()) == CommonResult.FAIL) {
        return CommonResult.FAIL;
      }
    }
    return CommonResult.SUCCESS;
  }
}
