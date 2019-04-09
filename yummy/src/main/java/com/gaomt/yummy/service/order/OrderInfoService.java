package com.gaomt.yummy.service.order;

import com.gaomt.yummy.vo.OrderCommVO;
import com.gaomt.yummy.vo.OrderVO;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:11 2019/2/26
 * @Description:
 */
public interface OrderInfoService {

  int addOrder(int userID, int resID, String number, String address, Timestamp arrive, double amount, ArrayList<OrderCommVO> orderCommVOs);

  OrderVO getOrderInfoByID(int orderID);

  ArrayList<OrderVO> getOrdersByUser(int userID);

  ArrayList<OrderVO> getOrdersByRes(int resID);

  double getAmountByID(int orderID);

}
