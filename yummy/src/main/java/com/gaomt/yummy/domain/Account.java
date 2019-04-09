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
@Table(name = "account")
public class Account {

  private Integer accountID = 1;
  private Double amount;

  @Id
  public Integer getAccountID() {
    return accountID;
  }

  public void setAccountID(Integer accountID) {
    this.accountID = accountID;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }
}
