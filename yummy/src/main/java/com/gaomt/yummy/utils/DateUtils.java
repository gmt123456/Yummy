package com.gaomt.yummy.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author： MengtingGao
 * @Date： Create in 10:09 2019/2/28
 * @Description:
 */
public class DateUtils {

  public static Date getDateAfterMinutes(Date date, int minutes) {
    Calendar start = Calendar.getInstance();
    start.setTime(date);
    start.add(Calendar.MINUTE, minutes);
    return start.getTime();
  }

  public static Date getDateAfterSeconds(Date date, int seconds) {
    Calendar start = Calendar.getInstance();
    start.setTime(date);
    start.add(Calendar.SECOND, seconds);
    return start.getTime();
  }

}
