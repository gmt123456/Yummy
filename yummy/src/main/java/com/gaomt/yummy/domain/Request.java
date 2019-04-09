package com.gaomt.yummy.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author： MengtingGao
 * @Date： Create in 13:01 2019/2/24
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "request")
public class Request {

  private Integer reqID;
  private Integer resID;
  private String reqType; // NAME,LOCATE,TYPE
  private String oldInfo;
  private String newInfo;
  private String state; // PENDING,AGREE,REJECT
  private Timestamp reqTime;
  private Timestamp apprTime;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getReqID() {
    return reqID;
  }

  public void setReqID(Integer reqID) {
    this.reqID = reqID;
  }

  public Integer getResID() {
    return resID;
  }

  public void setResID(Integer resID) {
    this.resID = resID;
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

  @Column(columnDefinition = "varchar(128) default 'PENDING'")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Timestamp getReqTime() {
    return reqTime;
  }

  public void setReqTime(Timestamp reqTime) {
    this.reqTime = reqTime;
  }

  public Timestamp getApprTime() {
    return apprTime;
  }

  public void setApprTime(Timestamp apprTime) {
    this.apprTime = apprTime;
  }
}
