package com.gaomt.yummy.vo;

import com.gaomt.yummy.domain.ResaurantType;

/**
 * @Author： MengtingGao
 * @Date： Create in 10:57 2019/2/26
 * @Description:
 */
public class ResaurantTypeVO {

  private int resTypeID;
  private String typeName;

  public void initByResaurantType(ResaurantType type) {
    resTypeID = type.getResTypeID();
    typeName = type.getTypeName();
  }

  public int getResTypeID() {
    return resTypeID;
  }

  public void setResTypeID(int resTypeID) {
    this.resTypeID = resTypeID;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }
}
