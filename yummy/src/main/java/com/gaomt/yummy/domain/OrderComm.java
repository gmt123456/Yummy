package com.gaomt.yummy.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Author： MengtingGao
 * @Date： Create in 13:02 2019/2/24
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "ordercomm")
public class OrderComm {

  private Integer orderCommID;
  private Integer commID;
  private Integer orderID;
  private String name;
  private Double price = 0.0;
  private Integer count = 0;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getOrderCommID() {
    return orderCommID;
  }

  public void setOrderCommID(Integer orderCommID) {
    this.orderCommID = orderCommID;
  }

  public Integer getCommID() {
    return commID;
  }

  public void setCommID(Integer commID) {
    this.commID = commID;
  }

  public Integer getOrderID() {
    return orderID;
  }

  public void setOrderID(Integer orderID) {
    this.orderID = orderID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }
}
