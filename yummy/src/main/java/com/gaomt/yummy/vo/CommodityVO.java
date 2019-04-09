package com.gaomt.yummy.vo;

import com.gaomt.yummy.domain.Commodity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * @Author： MengtingGao
 * @Date： Create in 19:52 2019/2/25
 * @Description:
 */
public class CommodityVO {

  private int commID;
  private double price;
  private int count;
  private String name;
  private String commType;
  private int resID;
  private double discount;
  private Date start;
  private Date end;
  private Date discStart;
  private Date discEnd;
  private String avatar;
  private int num = 0;

  public void initByCommodity(Commodity commodity) {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    commID = commodity.getCommID();
    price = commodity.getPrice();
    count = commodity.getCount();
    name = commodity.getName();
    commType = commodity.getCommType();
    resID = commodity.getResID();
    discount = commodity.getDiscount();
    start = commodity.getStart();
    end = commodity.getEnd();
    discStart = commodity.getDiscStart();
    discEnd = commodity.getDiscEnd();
    avatar = commodity.getAvatar();
  }

  public int getCommID() {
    return commID;
  }

  public void setCommID(int commID) {
    this.commID = commID;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
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

  public int getResID() {
    return resID;
  }

  public void setResID(int resID) {
    this.resID = resID;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
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

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }
}
