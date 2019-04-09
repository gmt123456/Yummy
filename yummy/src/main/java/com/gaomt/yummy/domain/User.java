package com.gaomt.yummy.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Author： MengtingGao
 * @Date： Create in 12:50 2019/2/24
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User {

  private Integer userID;
  private String email;
  private String password;
  private Integer level = 0;
  private String numbers;
  private String name;
  private Integer addrID;
  private Integer count = 0;
  private Double amount = 0.0;
  private Double balance = 2000.0;
  private String state; // REGISTERED,CANCELED
  private String avatar;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getNumbers() {
    return numbers;
  }

  public void setNumbers(String userNumber) {
    this.numbers = userNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAddrID() {
    return addrID;
  }

  public void setAddrID(Integer addrID) {
    this.addrID = addrID;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  @Column(columnDefinition = "varchar(128) default 'REGISTERED'")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
