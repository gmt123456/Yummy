package com.gaomt.yummy.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Author： MengtingGao
 * @Date： Create in 13:03 2019/2/24
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "manager")
public class Manager {

  private Integer managerID;
  private String password;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getManagerID() {
    return managerID;
  }

  public void setManagerID(Integer managerID) {
    this.managerID = managerID;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
