package com.gaomt.yummy.vo;

import com.gaomt.yummy.constant.LoginResult;

/**
 * @Author： MengtingGao
 * @Date： Create in 14:46 2019/2/25
 * @Description:
 */
public class LoginResultVO {

  private String result;
  private int userID;

  public String getResult() {
    return result;
  }

  public void setResult(LoginResult result) {
    this.result = result.toString();
  }

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

}
