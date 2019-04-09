package com.gaomt.yummy.service.delivery;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.constant.DeliveryType;
import com.gaomt.yummy.vo.DeliveryVO;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 9:12 2019/3/20
 * @Description:
 */
public interface DeliveryService {

  ArrayList<DeliveryVO> getDeliveriesByOrderID(int orderID);

  CommonResult addDelivery(int orderID, DeliveryType type);

}
