package com.gaomt.yummy.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Author： MengtingGao
 * @Date： Create in 23:08 2019/3/6
 * @Description:
 */
public class DiscountVO {

  private ArrayList<Integer> commIDs;
  private double discount;
  private Date start;
  private Date end;

  public ArrayList<Integer> getCommIDs() {
    return commIDs;
  }

  public void setCommIDs(ArrayList<Integer> commIDs) {
    this.commIDs = commIDs;
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
}
