package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author： MengtingGao
 * @Date： Create in 13:33 2019/2/24
 * @Description:
 */
@Repository
public interface UserDAO extends JpaRepository<User, Integer>{

  User findByEmail(String email);

  @Query(nativeQuery = true, value = "SELECT COUNT(userID) AS number FROM user")
  int getCount();

}
