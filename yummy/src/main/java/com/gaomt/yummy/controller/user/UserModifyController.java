package com.gaomt.yummy.controller.user;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.constant.PasswordResult;
import com.gaomt.yummy.service.user.UserModifyService;
import com.gaomt.yummy.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author： MengtingGao
 * @Date： Create in 17:06 2019/3/6
 * @Description:
 */
@RestController
@RequestMapping("/user/modify")
@CrossOrigin("http://localhost:8010")
public class UserModifyController {

  @Autowired
  private UserModifyService userModifyService;

  @RequestMapping(value = "/number", method = RequestMethod.POST)
  CommonResult modifyUserNumber(@RequestParam(value = "userID") int userID,
                                @RequestParam(value = "newNumber") String newNumber) {
    return userModifyService.modifyUserNumber(userID, newNumber);
  }

  @RequestMapping(value = "/name", method = RequestMethod.POST)
  CommonResult modifyUserName(@RequestParam(value = "userID") int userID,
                              @RequestParam(value = "newName") String newName) {
    return userModifyService.modifyUserName(userID, newName);
  }

  @RequestMapping(value = "/password", method = RequestMethod.POST)
  PasswordResult modifyUserPassword(@RequestParam(value = "userID") int userID,
                                    @RequestParam(value = "oldPassword") String oldPassword,
                                    @RequestParam(value = "newPassword") String newPassword) {
    return userModifyService.modifyUserPassword(userID, oldPassword, newPassword);
  }

  @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
  AddressVO addUserAddress(@RequestParam(value = "userID") int userID,
                           @RequestParam(value = "address") String address) {
    return userModifyService.addUserAddress(userID, address);
  }

  @RequestMapping(value = "/defAddress", method = RequestMethod.POST)
  CommonResult modifyUserDefAddr(@RequestParam(value = "userID") int userID,
                                 @RequestParam(value = "addrID") int addrID) {
    return userModifyService.modifyUserDefAddr(userID, addrID);
  }

  @RequestMapping(value = "/address", method = RequestMethod.POST)
  CommonResult modifyUserAddress(@RequestParam(value = "userID") int userID,
                                 @RequestParam(value = "addrID") int addrID,
                                 @RequestParam(value = "address") String address) {
    return userModifyService.modifyUserAddress(userID, addrID, address);
  }

  @RequestMapping(value = "/avatar", method = RequestMethod.POST)
  CommonResult modifyUserAvatar(@RequestParam(value = "userID") int userID,
                                @RequestParam(value = "imageData") String imageData) {
    return userModifyService.modifyUserAvatar(userID, imageData);
  }
}
