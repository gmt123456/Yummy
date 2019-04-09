package com.gaomt.yummy.vo;

import com.gaomt.yummy.domain.Orders;

import java.util.Date;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:15 2019/2/26
 * @Description:
 */
public class OrderVO {

  private int orderID;
  private int userID;
  private String userName;
  private int resID;
  private String resName;
  private String number;
  private String address;
  private Date time;
  private Date arrive;
  private double amount;
  private String state; // UNPAID, UNACCEPTED, ACCEPTED, DELIVERY, FINISH

  public void initByOrder(Orders orders, String userName, String resName) {
    this.userName = userName;
    this.resName = resName;
    orderID = orders.getOrderID();
    userID = orders.getUserID();
    resID = orders.getResID();
    number = orders.getNumbers();
    address = orders.getAddress();
    time = orders.getTime();
    arrive = orders.getArrive();
    amount = orders.getAmount();
    state = orders.getState();
  }

  public int getOrderID() {
    return orderID;
  }

  public void setOrderID(int orderID) {
    this.orderID = orderID;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public int getResID() {
    return resID;
  }

  public void setResID(int resID) {
    this.resID = resID;
  }

  public String getResName() {
    return resName;
  }

  public void setResName(String resName) {
    this.resName = resName;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public Date getArrive() {
    return arrive;
  }

  public void setArrive(Date arrive) {
    this.arrive = arrive;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

}
