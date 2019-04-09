package com.gaomt.yummy.controller.user;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.service.user.UserAccessService;
import com.gaomt.yummy.service.user.UserInfoService;
import com.gaomt.yummy.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:27 2019/3/6
 * @Description:
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:8010")
public class UserController {

  @Autowired
  private UserAccessService userAccessService;

  @Autowired
  private UserInfoService userInfoService;

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  RegisterResultVO register(@RequestParam(value = "email") String email,
                            @RequestParam(value = "password") String password) {
    return userAccessService.register(email, password);
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  LoginResultVO login(@RequestParam(value = "email") String email,
                      @RequestParam(value = "password") String password) {
    return userAccessService.login(email, password);
  }

  @RequestMapping(value = "/writeOff", method = RequestMethod.POST)
  CommonResult writeOff(@RequestParam(value = "userID") int userID) {
    userAccessService.writeOff(userID);
    return CommonResult.SUCCESS;
  }

  @RequestMapping(value = "/info", method = RequestMethod.POST)
  UserVO getUserInfo(@RequestParam(value = "userID") int userID) {
    return userInfoService.getUserInfo(userID);
  }

  @RequestMapping(value = "/defAddress", method = RequestMethod.POST)
  AddressVO getUserDefAddr(@RequestParam(value = "userID") int userID) {
    return userInfoService.getUserDefAddr(userID);
  }

  @RequestMapping(value = "/allAddress", method = RequestMethod.POST)
  ArrayList<AddressVO> getUserAllAddr(@RequestParam(value = "userID") int userID) {
    return userInfoService.getUserAllAddr(userID);
  }

  @RequestMapping(value = "/count", method = RequestMethod.POST)
  int getCounts() {
    return userInfoService.getCounts();
  }

  @RequestMapping(value = "/discount", method = RequestMethod.POST)
  double getLevelDiscount(@RequestParam(value = "userID") int userID) {
    return userInfoService.getLevelDiscount(userID);
  }

}
