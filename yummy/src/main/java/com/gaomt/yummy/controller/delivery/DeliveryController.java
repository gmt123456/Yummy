package com.gaomt.yummy.controller.delivery;

import com.gaomt.yummy.service.delivery.DeliveryService;
import com.gaomt.yummy.vo.DeliveryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 9:24 2019/3/20
 * @Description:
 */
@RestController
@RequestMapping("/delivery")
@CrossOrigin("http://localhost:8010")
public class DeliveryController {

  @Autowired
  private DeliveryService deliveryService;

  @RequestMapping(value = "/order", method = RequestMethod.POST)
  ArrayList<DeliveryVO> getDeliveriesByOrderID(@RequestParam(value = "orderID") int orderID) {
    return deliveryService.getDeliveriesByOrderID(orderID);
  }
}
