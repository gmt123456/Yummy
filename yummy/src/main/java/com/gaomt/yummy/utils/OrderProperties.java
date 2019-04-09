package com.gaomt.yummy.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author： MengtingGao
 * @Date： Create in 20:15 2019/2/27
 * @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "order")
public class OrderProperties {

  @Value("${order.cancel.minutes}")
  private String cancelMinutes;
  @Value("${order.confirm.minutes}")
  private String confirmMinutes;

  public int getCancelMinutes() {
    return Integer.parseInt(cancelMinutes);
  }

  public void setCancelMinutes(String minutes) {
    this.cancelMinutes = minutes;
  }

  public int getConfirmMinutes() {
    return Integer.parseInt(confirmMinutes);
  }

  public void setConfirmMinutes(String confirmMinutes) {
    this.confirmMinutes = confirmMinutes;
  }
}
