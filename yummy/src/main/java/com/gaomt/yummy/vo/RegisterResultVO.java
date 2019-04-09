package com.gaomt.yummy.vo;

import com.gaomt.yummy.constant.RegisterResult;

/**
 * @Author： MengtingGao
 * @Date： Create in 8:54 2019/2/25
 * @Description:
 */
public class RegisterResultVO {

  private String result;
  private int userID;

  public String getResult() {
    return result;
  }

  public void setResult(RegisterResult result) {
    this.result = result.toString();
  }

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

}
