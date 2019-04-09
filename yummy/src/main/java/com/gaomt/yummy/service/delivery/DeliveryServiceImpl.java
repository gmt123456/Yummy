package com.gaomt.yummy.service.delivery;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.constant.DeliveryType;
import com.gaomt.yummy.domain.Delivery;
import com.gaomt.yummy.repository.DeliveryDAO;
import com.gaomt.yummy.vo.DeliveryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 9:12 2019/3/20
 * @Description:
 */
@Service
public class DeliveryServiceImpl implements DeliveryService{

  @Autowired
  private DeliveryDAO deliveryDAO;

  @Override
  public ArrayList<DeliveryVO> getDeliveriesByOrderID(int orderID) {
    List<Delivery> deliveries = deliveryDAO.findDeliveriesByOrderID(orderID);
    ArrayList<DeliveryVO> deliveryVOS = new ArrayList<>();
    DeliveryVO deliveryVO;

    for (Delivery delivery: deliveries) {
      deliveryVO = new DeliveryVO();
      deliveryVO.initByDelivery(delivery);
      deliveryVOS.add(deliveryVO);
    }
    return deliveryVOS;
  }

  @Override
  public CommonResult addDelivery(int orderID, DeliveryType type) {
    Delivery delivery = new Delivery();
    delivery.setOrderID(orderID);
    delivery.setTime(new Timestamp(new Date().getTime()));
    delivery.setDelType(type.toString());
    deliveryDAO.save(delivery);
    return CommonResult.SUCCESS;
  }
}
