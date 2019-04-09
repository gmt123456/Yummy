package com.gaomt.yummy.service.order;

import com.gaomt.yummy.vo.OrderCommVO;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:46 2019/2/26
 * @Description:
 */
public interface OrderCommService {

  void addOrderCommsByVOs(ArrayList<OrderCommVO> orderCommVOS, int orderID);

  ArrayList<OrderCommVO> getOrderCommsByOrderID(int orderID);

}
