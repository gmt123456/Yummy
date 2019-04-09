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
@Table(name = "address")
public class Address {

  private Integer addrID;
  private Integer userID;
  private String address;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getAddrID() {
    return addrID;
  }

  public void setAddrID(Integer addrID) {
    this.addrID = addrID;
  }

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
