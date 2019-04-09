package com.gaomt.yummy.service.order;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.constant.OrderState;
import com.gaomt.yummy.constant.PayResult;

import java.util.Date;

/**
 * @Author： MengtingGao
 * @Date： Create in 17:13 2019/2/26
 * @Description:
 */
public interface OrderStateService {

  void receiveOrder(int orderID);

  void deliveryOrder(int orderID);

  void arriveOrder(int orderID);

  void cancelOrder(int orderID, Date date);

  void cancelOrder(int orderID);

  PayResult payForOrder(int userID, int orderID);

  CommonResult unsubOrder(int userID, int orderID);

  void confirmDelivery(int orderID);

  OrderState getStateByID(int orderID);

}
