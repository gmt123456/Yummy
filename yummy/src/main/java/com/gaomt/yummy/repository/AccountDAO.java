package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author： MengtingGao
 * @Date： Create in 8:41 2019/2/26
 * @Description:
 */
@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {

  Account findAccountByAccountID(int accoundID);

}
