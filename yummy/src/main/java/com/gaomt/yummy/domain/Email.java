package com.gaomt.yummy.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Author： MengtingGao
 * @Date： Create in 13:01 2019/2/24
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "email")
public class Email {

  private Integer emailID;
  private String email;
  private String code;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getEmailID() {
    return emailID;
  }

  public void setEmailID(Integer emailID) {
    this.emailID = emailID;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
