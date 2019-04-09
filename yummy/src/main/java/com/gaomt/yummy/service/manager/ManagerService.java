package com.gaomt.yummy.service.manager;

import com.gaomt.yummy.constant.LoginResult;

/**
 * @Author： MengtingGao
 * @Date： Create in 11:14 2019/2/27
 * @Description:
 */
public interface ManagerService {

  LoginResult login(int managerID, String password);

}
