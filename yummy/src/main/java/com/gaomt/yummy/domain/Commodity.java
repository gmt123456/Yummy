package com.gaomt.yummy.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Date;

/**
 * @Author： MengtingGao
 * @Date： Create in 13:02 2019/2/24
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "commodity")
public class Commodity {

  private Integer commID;
  private Double price = 0.0;
  private Integer count = 0;
  private String name;
  private String commType; // COMMODITY, PACKAGE
  private Integer resID;
  private Double discount = 0.0;
  private Date start;
  private Date end;
  private Date discStart;
  private Date discEnd;
  private String avatar;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getCommID() {
    return commID;
  }

  public void setCommID(Integer commID) {
    this.commID = commID;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCommType() {
    return commType;
  }

  public void setCommType(String commType) {
    this.commType = commType;
  }

  public Integer getResID() {
    return resID;
  }

  public void setResID(Integer resID) {
    this.resID = resID;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public Date getDiscStart() {
    return discStart;
  }

  public void setDiscStart(Date discStart) {
    this.discStart = discStart;
  }

  public Date getDiscEnd() {
    return discEnd;
  }

  public void setDiscEnd(Date discEnd) {
    this.discEnd = discEnd;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
