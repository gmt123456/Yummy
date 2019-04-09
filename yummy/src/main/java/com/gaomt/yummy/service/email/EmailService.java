package com.gaomt.yummy.service.email;

import com.gaomt.yummy.constant.CommonResult;

/**
 * @Author： MengtingGao
 * @Date： Create in 14:09 2019/2/24
 * @Description:
 */
public interface EmailService {

  void sendEmailCode(String email);

  CommonResult confirmEmailCode(String email, String code);

}
