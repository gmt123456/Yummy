package com.gaomt.yummy.service.user;

import com.gaomt.yummy.constant.PayResult;
import com.gaomt.yummy.vo.LoginResultVO;
import com.gaomt.yummy.vo.RegisterResultVO;

/**
 * @Author： MengtingGao
 * @Date： Create in 8:09 2019/2/25
 * @Description:
 */
public interface UserAccessService {

  RegisterResultVO register(String email, String password);

  LoginResultVO login(String email, String password);

  void writeOff(int userID);

  PayResult pay(int userID, double amount);

  void returnMoney(int userID, double amount);

}
