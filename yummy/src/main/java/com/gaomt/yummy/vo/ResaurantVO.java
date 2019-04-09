package com.gaomt.yummy.vo;

import com.gaomt.yummy.domain.Resaurant;

/**
 * @Author： MengtingGao
 * @Date： Create in 21:27 2019/2/25
 * @Description:
 */
public class ResaurantVO {

  private int resID;
  private String name;
  private String locate;
  private String resType;
  private String avatar;
  private double balance;
  private double amount;
  private int distance = 0;
  private int time = 0;

  public void initByResaurant(Resaurant resaurant, String resType) {
    this.resType = resType;
    resID = resaurant.getResID();
    name = resaurant.getName();
    locate = resaurant.getLocate();
    avatar = resaurant.getAvatar();
    balance = resaurant.getBalance();
    amount = resaurant.getAmount();
  }

  public int getResID() {
    return resID;
  }

  public void setResID(int resID) {
    this.resID = resID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocate() {
    return locate;
  }

  public void setLocate(String locate) {
    this.locate = locate;
  }

  public String getResType() {
    return resType;
  }

  public void setResType(String resType) {
    this.resType = resType;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }
}
