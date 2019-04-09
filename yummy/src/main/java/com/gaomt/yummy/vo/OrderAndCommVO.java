package com.gaomt.yummy.vo;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 22:59 2019/3/6
 * @Description:
 */
public class OrderAndCommVO {

  private int userID;
  private int resID;
  private String number;
  private String address;
  private Timestamp arrive;
  private double amount;
  private ArrayList<OrderCommVO> orderCommVOs;

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public int getResID() {
    return resID;
  }

  public void setResID(int resID) {
    this.resID = resID;
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

  public Timestamp getArrive() {
    return arrive;
  }

  public void setArrive(Timestamp arrive) {
    this.arrive = arrive;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public ArrayList<OrderCommVO> getOrderCommVOs() {
    return orderCommVOs;
  }

  public void setOrderCommVOs(ArrayList<OrderCommVO> orderCommVOs) {
    this.orderCommVOs = orderCommVOs;
  }
}
