package com.gaomt.yummy.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author： MengtingGao
 * @Date： Create in 13:03 2019/2/24
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "record")
public class Record {

  private Integer recordID;
  private String recType;
  private Timestamp time;
  private Double amount = 0.0;
  private Integer level;
  private Integer resID;
  private Integer userID;
  private Integer orderID;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getRecordID() {
    return recordID;
  }

  public void setRecordID(Integer recordID) {
    this.recordID = recordID;
  }

  public String getRecType() {
    return recType;
  }

  public void setRecType(String recType) {
    this.recType = recType;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Integer getResID() {
    return resID;
  }

  public void setResID(Integer resID) {
    this.resID = resID;
  }

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public Integer getOrderID() {
    return orderID;
  }

  public void setOrderID(Integer orderID) {
    this.orderID = orderID;
  }

}
