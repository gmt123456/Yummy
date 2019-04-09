package com.gaomt.yummy.vo;

import com.gaomt.yummy.domain.Record;

import java.util.Date;

/**
 * @Author： MengtingGao
 * @Date： Create in 11:01 2019/2/27
 * @Description:
 */
public class RecordVO {

  private int recordID;
  private String recType;
  private Date time;
  private double amount;
  private int level;
  private int resID;
  private int userID;
  private int orderID;

  public void initByRecord(Record record) {
    recordID = record.getRecordID();
    recType = record.getRecType();
    time = record.getTime();
    amount = record.getAmount();
    resID = record.getResID();
    userID = record.getUserID();
    orderID = record.getOrderID();
    level = record.getLevel() == null ? 0 : record.getLevel();
  }

  public int getRecordID() {
    return recordID;
  }

  public void setRecordID(int recordID) {
    this.recordID = recordID;
  }

  public String getRecType() {
    return recType;
  }

  public void setRecType(String recType) {
    this.recType = recType;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getResID() {
    return resID;
  }

  public void setResID(int resID) {
    this.resID = resID;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public int getOrderID() {
    return orderID;
  }

  public void setOrderID(int orderID) {
    this.orderID = orderID;
  }
}
