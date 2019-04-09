package com.gaomt.yummy.controller.email;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author： MengtingGao
 * @Date： Create in 21:44 2019/3/6
 * @Description:
 */
@RestController
@RequestMapping("/email")
@CrossOrigin("http://localhost:8010")
public class EmailController {

  @Autowired
  private EmailService emailService;

  @RequestMapping(value = "/send", method = RequestMethod.POST)
  CommonResult sendEmailCode(@RequestParam(value = "email") String email) {
    emailService.sendEmailCode(email);
    return CommonResult.SUCCESS;
  }

  @RequestMapping(value = "/confirm", method = RequestMethod.POST)
  CommonResult confirmEmailCode(@RequestParam(value = "email") String email,
                                @RequestParam(value = "code") String code) {
    return emailService.confirmEmailCode(email, code);
  }

}
