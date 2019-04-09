package com.gaomt.yummy.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author： MengtingGao
 * @Date： Create in 9:03 2019/3/20
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "delivery")
public class Delivery {

  private Integer delID;
  private Integer orderID;
  private String delType;
  private Timestamp time;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getDelID() {
    return delID;
  }

  public void setDelID(Integer delID) {
    this.delID = delID;
  }

  public Integer getOrderID() {
    return orderID;
  }

  public void setOrderID(Integer orderID) {
    this.orderID = orderID;
  }

  public String getDelType() {
    return delType;
  }

  public void setDelType(String delType) {
    this.delType = delType;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }
}
