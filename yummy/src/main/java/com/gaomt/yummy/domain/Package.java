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
@Table(name = "package")
public class Package {

  private Integer id;
  private Integer pkgID;
  private Integer commID;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPkgID() {
    return pkgID;
  }

  public void setPkgID(Integer pkgID) {
    this.pkgID = pkgID;
  }

  public Integer getCommID() {
    return commID;
  }

  public void setCommID(Integer commID) {
    this.commID = commID;
  }

}
