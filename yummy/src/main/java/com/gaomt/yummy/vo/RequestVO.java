package com.gaomt.yummy.vo;

import com.gaomt.yummy.domain.Request;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： MengtingGao
 * @Date： Create in 9:20 2019/2/26
 * @Description:
 */
public class RequestVO {

  private int reqID;
  private int resID;
  private String resName;
  private String reqType; // NAME,LOCATE,TYPE
  private String oldInfo;
  private String newInfo;
  private String state; // PENDING,AGREE,REJECT
  private Date reqTime;
  private Date apprTime;

  public void initByRequest(Request request, String resName) {
    this.resName = resName;
    reqID = request.getReqID();
    resID = request.getResID();
    reqType = request.getReqType();
    oldInfo = request.getOldInfo();
    newInfo = request.getNewInfo();
    state = request.getState();
    reqTime = request.getReqTime();
    apprTime = request.getApprTime();
  }

  public int getReqID() {
    return reqID;
  }

  public void setReqID(int reqID) {
    this.reqID = reqID;
  }

  public int getResID() {
    return resID;
  }

  public void setResID(int resID) {
    this.resID = resID;
  }

  public String getResName() {
    return resName;
  }

  public void setResName(String resName) {
    this.resName = resName;
  }

  public String getReqType() {
    return reqType;
  }

  public void setReqType(String reqType) {
    this.reqType = reqType;
  }

  public String getOldInfo() {
    return oldInfo;
  }

  public void setOldInfo(String oldInfo) {
    this.oldInfo = oldInfo;
  }

  public String getNewInfo() {
    return newInfo;
  }

  public void setNewInfo(String newInfo) {
    this.newInfo = newInfo;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Date getReqTime() {
    return reqTime;
  }

  public void setReqTime(Date reqTime) {
    this.reqTime = reqTime;
  }

  public Date getApprTime() {
    return apprTime;
  }

  public void setApprTime(Date apprTime) {
    this.apprTime = apprTime;
  }
}
