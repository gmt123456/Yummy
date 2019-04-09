package com.gaomt.yummy.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author： MengtingGao
 * @Date： Create in 18:49 2019/2/25
 * @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "level")
public class UserLevelProperties {

  @Value("${level.l1.amount}")
  private String L1Amount;
  @Value("${level.l1.count}")
  private String L1Count;
  @Value("${level.l1.discount}")
  private String L1Discount;
  @Value("${level.l2.amount}")
  private String L2Amount;
  @Value("${level.l2.count}")
  private String L2Count;
  @Value("${level.l2.discount}")
  private String L2Discount;
  @Value("${level.l3.amount}")
  private String L3Amount;
  @Value("${level.l3.count}")
  private String L3Count;
  @Value("${level.l3.discount}")
  private String L3Discount;

  public double getL1Amount() {
    return Double.parseDouble(L1Amount);
  }

  public void setL1Amount(double l1Amount) {
    L1Amount = String.valueOf(l1Amount);
  }

  public int getL1Count() {
    return Integer.parseInt(L1Count);
  }

  public void setL1Count(int l1Count) {
    L1Count = String.valueOf(l1Count);
  }

  public int getL1Discount() {
    return Integer.parseInt(L1Discount);
  }

  public void setL1Discount(int l1Discount) {
    L1Discount = String.valueOf(l1Discount);
  }

  public double getL2Amount() {
    return Double.parseDouble(L2Amount);
  }

  public void setL2Amount(double l2Amount) {
    L2Amount = String.valueOf(l2Amount);
  }

  public int getL2Count() {
    return Integer.parseInt(L2Count);
  }

  public void setL2Count(int l2Count) {
    L2Count = String.valueOf(l2Count);
  }

  public int getL2Discount() {
    return Integer.parseInt(L2Discount);
  }

  public void setL2Discount(int l2Discount) {
    L2Discount = String.valueOf(l2Discount);
  }

  public double getL3Amount() {
    return Double.parseDouble(L3Amount);
  }

  public void setL3Amount(double l3Amount) {
    L3Amount = String.valueOf(l3Amount);
  }

  public int getL3Count() {
    return Integer.parseInt(L3Count);
  }

  public void setL3Count(int l3Count) {
    L3Count = String.valueOf(l3Count);
  }

  public int getL3Discount() {
    return Integer.parseInt(L3Discount);
  }

  public void setL3Discount(int l3Discount) {
    L3Discount = String.valueOf(l3Discount);
  }
}
