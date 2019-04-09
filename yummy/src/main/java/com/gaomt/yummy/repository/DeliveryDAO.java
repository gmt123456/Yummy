package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 9:05 2019/3/20
 * @Description:
 */
@Repository
public interface DeliveryDAO extends JpaRepository<Delivery, Integer> {

  List<Delivery> findDeliveriesByOrderID(int orderID);

}
