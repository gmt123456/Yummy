package com.gaomt.yummy.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Author： MengtingGao
 * @Date： Create in 13:01 2019/2/24
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "resaurant")
public class Resaurant {

  private Integer resID;
  private String name;
  private String password;
  private String locate;
  private Integer resTypeID = 1;
  private Double balance = 0.0;
  private Double amount = 0.0;
  private String avatar;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getResID() {
    return resID;
  }

  public void setResID(Integer resID) {
    this.resID = resID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getLocate() {
    return locate;
  }

  public void setLocate(String locate) {
    this.locate = locate;
  }

  public Integer getResTypeID() {
    return resTypeID;
  }

  public void setResTypeID(Integer resTypeID) {
    this.resTypeID = resTypeID;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
