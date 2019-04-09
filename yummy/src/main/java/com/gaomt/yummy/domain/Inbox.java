package com.gaomt.yummy.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Author： MengtingGao
 * @Date： Create in 13:02 2019/2/24
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "inbox")
public class Inbox {

  private Integer inboxID;
  private Integer reqID;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getInboxID() {
    return inboxID;
  }

  public void setInboxID(Integer inboxID) {
    this.inboxID = inboxID;
  }

  public Integer getReqID() {
    return reqID;
  }

  public void setReqID(Integer reqID) {
    this.reqID = reqID;
  }

}
