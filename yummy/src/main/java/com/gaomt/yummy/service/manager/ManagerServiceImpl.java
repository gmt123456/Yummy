package com.gaomt.yummy.service.manager;

import com.gaomt.yummy.constant.LoginResult;
import com.gaomt.yummy.domain.Manager;
import com.gaomt.yummy.repository.ManagerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author： MengtingGao
 * @Date： Create in 11:15 2019/2/27
 * @Description:
 */
@Service
public class ManagerServiceImpl implements ManagerService {

  @Autowired
  private ManagerDAO managerDAO;

  @Override
  public LoginResult login(int managerID, String password) {
    if (managerDAO.findById(managerID).isPresent()) {
      Manager manager = managerDAO.findById(managerID).get();
      if (manager.getPassword().equals(password)) return LoginResult.SUCCESS;
      else return LoginResult.PASSWORD_ERROR;
    }
    else return LoginResult.ID_ERROR;
  }
}
