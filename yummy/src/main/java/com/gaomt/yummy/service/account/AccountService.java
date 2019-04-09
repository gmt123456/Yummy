package com.gaomt.yummy.service.account;

/**
 * @Author： MengtingGao
 * @Date： Create in 8:42 2019/2/26
 * @Description:
 */
public interface AccountService {

  void earn(double amount);

  void pay(double amount);

  double getAmount();

}
