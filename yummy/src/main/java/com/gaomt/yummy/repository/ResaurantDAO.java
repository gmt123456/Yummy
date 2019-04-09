package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.Resaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 21:17 2019/2/25
 * @Description:
 */
@Repository
public interface ResaurantDAO extends JpaRepository<Resaurant, Integer> {

  @Modifying @Query(nativeQuery = true, value = "UPDATE resaurant SET balance = balance + amount * :discount, amount = 0.0")
  void settle(@Param("discount") double discount);

  @Query(nativeQuery = true, value = "SELECT SUM(amount) AS total FROM resaurant")
  double getSumAmount();

  @Query(nativeQuery = true, value = "SELECT COUNT(resID) AS number FROM resaurant")
  int getCount();
}
