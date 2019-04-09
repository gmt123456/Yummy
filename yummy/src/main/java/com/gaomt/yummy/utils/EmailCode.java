package com.gaomt.yummy.utils;

import java.util.Random;

/**
 * @Author： MengtingGao
 * @Date： Create in 14:55 2019/2/24
 * @Description:
 */
public class EmailCode {

  public String getRandomCode(int codeLength) {
    Random random = new Random();
    int length;
    String code = "";

    if (codeLength > 20 || codeLength <= 0) {
      length = 8;
    }
    else {
      length = codeLength;
    }

    for (int i = 0;i < length;i++){
      boolean b = random.nextBoolean();
      if (b) {
        code += random.nextInt(10);
      }
      else {
        int choice = random.nextBoolean() ? 65 : 97;
        code += (char) (choice + random.nextInt(26));
      }
    }
    return code;
  }
}
