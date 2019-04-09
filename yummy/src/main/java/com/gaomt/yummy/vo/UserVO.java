package com.gaomt.yummy.vo;

import com.gaomt.yummy.domain.User;

/**
 * @Author： MengtingGao
 * @Date： Create in 8:12 2019/2/25
 * @Description:
 */
public class UserVO {

  private int userID;
  private String email;
  private int level;
  private String number;
  private String name;
  private String address;
  private String avatar;
  private double balance;

  public void initByUser(User user, String address) {
    userID = user.getUserID();
    email = user.getEmail();
    level = user.getLevel();
    number = user.getNumbers();
    name = user.getName();
    avatar = user.getAvatar();
    balance = user.getBalance();
    this.address = address;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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
}
