package com.gaomt.yummy.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author： MengtingGao
 * @Date： Create in 14:33 2019/2/24
 * @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailProperties {

  @Value("${mail.from}")
  private String from;
  @Value("${mail.subject}")
  private String subject;
  @Value("${mail.length}")
  private String length;

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getLength() {
    return length;
  }

  public void setLength(String length) {
    this.length = length;
  }
}
