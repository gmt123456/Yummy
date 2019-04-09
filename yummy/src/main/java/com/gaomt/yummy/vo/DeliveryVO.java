package com.gaomt.yummy.vo;

import com.gaomt.yummy.domain.Delivery;

import java.util.Date;

/**
 * @Author： MengtingGao
 * @Date： Create in 9:08 2019/3/20
 * @Description:
 */
public class DeliveryVO {

  private int delID;
  private int orderID;
  private String delType;
  private Date time;

  public void initByDelivery(Delivery delivery) {
    delID = delivery.getDelID();
    orderID = delivery.getOrderID();
    delType = delivery.getDelType();
    time = delivery.getTime();
  }

  public int getDelID() {
    return delID;
  }

  public void setDelID(int delID) {
    this.delID = delID;
  }

  public int getOrderID() {
    return orderID;
  }

  public void setOrderID(int orderID) {
    this.orderID = orderID;
  }

  public String getDelType() {
    return delType;
  }

  public void setDelType(String delType) {
    this.delType = delType;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
}
