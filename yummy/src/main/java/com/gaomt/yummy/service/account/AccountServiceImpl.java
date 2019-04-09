package com.gaomt.yummy.service.account;

import com.gaomt.yummy.domain.Account;
import com.gaomt.yummy.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author： MengtingGao
 * @Date： Create in 8:43 2019/2/26
 * @Description:
 */
@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountDAO accountDAO;

  @Override
  public void earn(double amount) {
    changeAmount(amount, true);
  }

  @Override
  public void pay(double amount) {
    changeAmount(amount, false);

  }

  @Override
  public double getAmount() {
    if (accountDAO.findById(1).isPresent()) {
      Account account = accountDAO.findById(1).get();
      return account.getAmount();
    }
    else System.out.println("Database `account` doesn't init!");
    return 0;
  }

  private void changeAmount(double amount, boolean isEarn) {
    if (accountDAO.findAccountByAccountID(1) == null) System.out.println("Database `account` doesn't init!");
    else {
      Account account = accountDAO.findAccountByAccountID(1);
      double oldAmount = account.getAmount();
      double newAmount;
      if (isEarn) newAmount = oldAmount + amount;
      else newAmount = oldAmount - amount;
      account.setAmount(newAmount);
      accountDAO.save(account);
    }
  }

}
