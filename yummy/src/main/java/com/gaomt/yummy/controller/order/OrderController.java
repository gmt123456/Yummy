package com.gaomt.yummy.controller.order;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.constant.OrderState;
import com.gaomt.yummy.constant.PayResult;
import com.gaomt.yummy.service.order.OrderCommService;
import com.gaomt.yummy.service.order.OrderInfoService;
import com.gaomt.yummy.service.order.OrderStateService;
import com.gaomt.yummy.vo.OrderAndCommVO;
import com.gaomt.yummy.vo.OrderCommVO;
import com.gaomt.yummy.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Author： MengtingGao
 * @Date： Create in 21:25 2019/3/6
 * @Description:
 */
@RestController
@RequestMapping("/order")
@CrossOrigin("http://localhost:8010")
public class OrderController {

  @Autowired
  private OrderInfoService orderInfoService;
  @Autowired
  private OrderStateService orderStateService;
  @Autowired
  private OrderCommService orderCommService;

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  int addOrder(@RequestBody OrderAndCommVO vo) {
    return orderInfoService.addOrder(vo.getUserID(), vo.getResID(), vo.getNumber(), vo.getAddress(), vo.getArrive(), vo.getAmount(), vo.getOrderCommVOs());
  }

  @RequestMapping(value = "/info", method = RequestMethod.POST)
  OrderVO getOrderInfoByID(@RequestParam(value = "orderID") int orderID) {
    return orderInfoService.getOrderInfoByID(orderID);
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  ArrayList<OrderVO> getOrdersByUser(@RequestParam(value = "userID") int userID) {
    return orderInfoService.getOrdersByUser(userID);
  }

  @RequestMapping(value = "/restaurant", method = RequestMethod.POST)
  ArrayList<OrderVO> getOrdersByRes(@RequestParam(value = "resID") int resID) {
    return orderInfoService.getOrdersByRes(resID);
  }

  @RequestMapping(value = "/amount", method = RequestMethod.POST)
  double getAmountByID(@RequestParam(value = "orderID") int orderID) {
    return orderInfoService.getAmountByID(orderID);
  }

  @RequestMapping(value = "/receive", method = RequestMethod.POST)
  CommonResult receiveOrder(@RequestParam(value = "orderID") int orderID) {
    orderStateService.receiveOrder(orderID);
    return CommonResult.SUCCESS;
  }

  @RequestMapping(value = "/delivery", method = RequestMethod.POST)
  CommonResult deliveryOrder(@RequestParam(value = "orderID") int orderID) {
    orderStateService.deliveryOrder(orderID);
    return CommonResult.SUCCESS;
  }

  @RequestMapping(value = "/arrive", method = RequestMethod.POST)
  CommonResult arriveOrder(@RequestParam(value = "orderID") int orderID) {
    orderStateService.arriveOrder(orderID);
    return CommonResult.SUCCESS;
  }

  @RequestMapping(value = "/pay", method = RequestMethod.POST)
  PayResult payForOrder(@RequestParam(value = "userID") int userID,
                        @RequestParam(value = "orderID") int orderID) {
    return orderStateService.payForOrder(userID, orderID);
  }

  @RequestMapping(value = "/unsub", method = RequestMethod.POST)
  CommonResult unsubOrder(@RequestParam(value = "userID") int userID,
                  @RequestParam(value = "orderID") int orderID) {
    return orderStateService.unsubOrder(userID, orderID);
  }

  @RequestMapping(value = "/confirm", method = RequestMethod.POST)
  CommonResult confirmDelivery(@RequestParam(value = "orderID") int orderID) {
    orderStateService.confirmDelivery(orderID);
    return CommonResult.SUCCESS;
  }

  @RequestMapping(value = "/state", method = RequestMethod.POST)
  OrderState getStateByID(@RequestParam(value = "orderID") int orderID) {
    return orderStateService.getStateByID(orderID);
  }

  @RequestMapping(value = "/commodities", method = RequestMethod.POST)
  ArrayList<OrderCommVO> getOrderCommsByOrderID(@RequestParam(value = "orderID") int orderID) {
    return orderCommService.getOrderCommsByOrderID(orderID);
  }

}
