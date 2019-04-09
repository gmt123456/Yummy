package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.ResaurantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author： MengtingGao
 * @Date： Create in 21:21 2019/2/25
 * @Description:
 */
@Repository
public interface ResaurantTypeDAO extends JpaRepository<ResaurantType, Integer> {

  ResaurantType findByTypeName(String name);

}
