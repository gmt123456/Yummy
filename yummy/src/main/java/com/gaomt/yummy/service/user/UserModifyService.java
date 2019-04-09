package com.gaomt.yummy.service.user;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.constant.PasswordResult;
import com.gaomt.yummy.vo.AddressVO;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:05 2019/2/25
 * @Description:
 */
public interface UserModifyService {

  CommonResult modifyUserNumber(int userID, String newNumber);

  CommonResult modifyUserName(int userID, String newName);

  PasswordResult modifyUserPassword(int userID, String oldPassword, String newPassword);

  AddressVO addUserAddress(int userID, String address);

  CommonResult modifyUserDefAddr(int userID, int addrID);

  CommonResult modifyUserAddress(int userID, int addrID, String address);

  void addUserCount(int userID);

  CommonResult modifyUserAvatar(int userID, String imageData);

}
