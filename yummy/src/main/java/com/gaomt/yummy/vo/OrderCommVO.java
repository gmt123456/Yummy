package com.gaomt.yummy.vo;

import com.gaomt.yummy.domain.OrderComm;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:17 2019/2/26
 * @Description:
 */
public class OrderCommVO {

  private int commID;
  private String name;
  private double price;
  private int count;
  private double amount;

  public OrderCommVO() {}

  public OrderCommVO(int commID, String name, double price, int count) {
    this.commID = commID;
    this.name = name;
    this.price = price;
    this.count = count;
    this.amount = price * count;
  }

  public void initByOrderCommm(OrderComm orderComm) {
    commID = orderComm.getCommID();
    name = orderComm.getName();
    price = orderComm.getPrice();
    count = orderComm.getCount();
    amount = price * count;
  }

  public int getCommID() {
    return commID;
  }

  public void setCommID(int commID) {
    this.commID = commID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}
