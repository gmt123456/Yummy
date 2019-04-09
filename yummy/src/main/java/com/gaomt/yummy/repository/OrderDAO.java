package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:09 2019/2/26
 * @Description:
 */
@Repository
public interface OrderDAO extends JpaRepository<Orders, Integer> {

  List<Orders> findOrdersByUserID(int userID);

  List<Orders> findOrdersByResID(int resID);

}
