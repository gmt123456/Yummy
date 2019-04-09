package com.gaomt.yummy.service.user;

import com.gaomt.yummy.vo.AddressVO;
import com.gaomt.yummy.vo.UserVO;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:05 2019/2/25
 * @Description:
 */
public interface UserInfoService {

  UserVO getUserInfo(int userID);

  AddressVO getUserDefAddr(int userID);

  ArrayList<AddressVO> getUserAllAddr(int userID);

  double getUserAmount(int userID);

  String getUserNameByID(int userID);

  int getUserLevelByID(int userID);

  int getCounts();

  double getLevelDiscount(int userID);

}
