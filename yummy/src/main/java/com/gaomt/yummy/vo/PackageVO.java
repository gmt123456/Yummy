package com.gaomt.yummy.vo;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 23:06 2019/3/6
 * @Description:
 */
public class PackageVO {

  private int resID;
  private String name;
  private double price;
  private int count;
  private ArrayList<Integer> commIDs;
  private String imageData;

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

  public ArrayList<Integer> getCommIDs() {
    return commIDs;
  }

  public void setCommIDs(ArrayList<Integer> commIDs) {
    this.commIDs = commIDs;
  }

  public String getImageData() {
    return imageData;
  }

  public void setImageData(String imageData) {
    this.imageData = imageData;
  }
}
