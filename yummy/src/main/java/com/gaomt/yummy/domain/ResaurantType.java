package com.gaomt.yummy.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Author： MengtingGao
 * @Date： Create in 21:19 2019/2/25
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "resauranttype")
public class ResaurantType {

 private Integer resTypeID;
 private String typeName;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 public Integer getResTypeID() {
  return resTypeID;
 }

 public void setResTypeID(Integer resTypeID) {
  this.resTypeID = resTypeID;
 }

 public String getTypeName() {
  return typeName;
 }

 public void setTypeName(String typeName) {
  this.typeName = typeName;
 }

}
