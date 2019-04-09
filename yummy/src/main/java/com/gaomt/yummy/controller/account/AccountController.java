package com.gaomt.yummy.controller.account;

import com.gaomt.yummy.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author： MengtingGao
 * @Date： Create in 23:18 2019/3/6
 * @Description:
 */
@RestController
@RequestMapping("/account")
@CrossOrigin("http://localhost:8010")
public class AccountController {

  @Autowired
  private AccountService accountService;

  @RequestMapping(value = "/number", method = RequestMethod.POST)
  double getAccount() {
    return accountService.getAmount();
  }
}
