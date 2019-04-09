package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author： MengtingGao
 * @Date： Create in 13:08 2019/2/24
 * @Description:
 */
@Repository
public interface EmailDAO extends JpaRepository<Email, Integer> {

  Email findByEmail(String email);

}
