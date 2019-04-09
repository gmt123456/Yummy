package com.gaomt.yummy.service.order;

import com.gaomt.yummy.domain.OrderComm;
import com.gaomt.yummy.repository.OrderCommDAO;
import com.gaomt.yummy.vo.OrderCommVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:47 2019/2/26
 * @Description:
 */
@Service
public class OrderCommServiceImpl implements OrderCommService {

  @Autowired
  OrderCommDAO orderCommDAO;

  @Override
  public void addOrderCommsByVOs(ArrayList<OrderCommVO> orderCommVOS, int orderID) {
    OrderComm orderComm;

    for (OrderCommVO commVO: orderCommVOS) {
      orderComm = new OrderComm();
      orderComm.setCount(commVO.getCount());
      orderComm.setName(commVO.getName());
      orderComm.setPrice(commVO.getPrice());
      orderComm.setCommID(commVO.getCommID());
      orderComm.setOrderID(orderID);
      orderCommDAO.save(orderComm);
    }
  }

  @Override
  public ArrayList<OrderCommVO> getOrderCommsByOrderID(int orderID) {
    List<OrderComm> orderComms = orderCommDAO.findAllByOrderID(orderID);
    ArrayList<OrderCommVO> orderCommVOS = new ArrayList<>();
    OrderCommVO orderCommVO;

    for (OrderComm orderComm: orderComms) {
      orderCommVO = new OrderCommVO();
      orderCommVO.initByOrderCommm(orderComm);
      orderCommVOS.add(orderCommVO);
    }
    return orderCommVOS;
  }
}
