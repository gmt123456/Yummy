package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author： MengtingGao
 * @Date： Create in 11:13 2019/2/27
 * @Description:
 */
@Repository
public interface ManagerDAO extends JpaRepository<Manager, Integer>{
}
