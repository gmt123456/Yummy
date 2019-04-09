package com.gaomt.yummy.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author： MengtingGao
 * @Date： Create in 13:02 2019/2/24
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "orders")
public class Orders {

  private Integer orderID;
  private Integer userID;
  private Integer resID;
  private String numbers;
  private String address;
  private Timestamp time;
  private Timestamp arrive;
  private Double amount = 0.0;
  private String state; // UNPAID, UNACCEPTED, ACCEPTED, DELIVERY, FINISH

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getOrderID() {
    return orderID;
  }

  public void setOrderID(Integer orderID) {
    this.orderID = orderID;
  }

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public Integer getResID() {
    return resID;
  }

  public void setResID(Integer resID) {
    this.resID = resID;
  }

  public String getNumbers() {
    return numbers;
  }

  public void setNumbers(String numbers) {
    this.numbers = numbers;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public Timestamp getArrive() {
    return arrive;
  }

  public void setArrive(Timestamp arrive) {
    this.arrive = arrive;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
