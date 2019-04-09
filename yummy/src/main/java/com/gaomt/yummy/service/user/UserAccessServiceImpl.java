package com.gaomt.yummy.service.user;

import com.gaomt.yummy.constant.*;
import com.gaomt.yummy.domain.User;
import com.gaomt.yummy.repository.UserDAO;
import com.gaomt.yummy.service.account.AccountService;
import com.gaomt.yummy.vo.LoginResultVO;
import com.gaomt.yummy.vo.RegisterResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author： MengtingGao
 * @Date： Create in 8:27 2019/2/25
 * @Description:
 */
@Service
public class UserAccessServiceImpl implements UserAccessService {

  @Autowired
  private UserDAO userDAO;
  @Autowired
  private AccountService accountService;

  @Override
  public RegisterResultVO register(String email, String password) {
    RegisterResultVO result = new RegisterResultVO();
    if (userDAO.findByEmail(email) == null) {
      User user = new User();
      user.setEmail(email);
      user.setPassword(password);
      user.setState(UserState.REGISTERED.toString());
      userDAO.save(user);
      user.setName("U_" + user.getUserID());
      userDAO.save(user);
      result.setUserID(user.getUserID());
      result.setResult(RegisterResult.SUCCESS);
    }
    else {
      result.setResult(RegisterResult.EMAIL_EXIST);
    }
    return result;
  }

  @Override
  public LoginResultVO login(String email, String password) {
    LoginResultVO result = new LoginResultVO();
    if (userDAO.findByEmail(email) == null) {
      result.setResult(LoginResult.ID_ERROR);
    }
    else {
      User user = userDAO.findByEmail(email);
      if (UserState.valueOf(user.getState()) == UserState.CANCELED) {
        result.setResult(LoginResult.ID_ERROR);
      }
      else {
        if (!user.getPassword().equals(password)) {
          result.setResult(LoginResult.PASSWORD_ERROR);
        } else {
          result.setResult(LoginResult.SUCCESS);
          result.setUserID(userDAO.findByEmail(email).getUserID());
        }
      }
    }
    return result;
  }

  @Override
  public void writeOff(int userID) {
    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();
      user.setState(UserState.CANCELED.toString());
      userDAO.save(user);
    }
  }

  @Override
  public PayResult pay(int userID, double amount) {
    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();
      double oldBalance = user.getBalance();

      if (oldBalance - amount < 0) return PayResult.NOT_SUFFICIENT_FUNDS;

      double newAmount = oldBalance - amount;
      user.setBalance(newAmount);
      user.setAmount(user.getAmount() + amount);
      userDAO.save(user);
      accountService.earn(amount);
      return PayResult.SUCCESS;
    }
    return PayResult.FAIL;
  }

  @Override
  public void returnMoney(int userID, double amount) {
    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();
      double oldBalance = user.getBalance();
      double newBalance = oldBalance + amount;
      user.setBalance(newBalance);
      user.setAmount(user.getAmount() - amount);
      userDAO.save(user);
      accountService.pay(amount);
    }
  }
}
