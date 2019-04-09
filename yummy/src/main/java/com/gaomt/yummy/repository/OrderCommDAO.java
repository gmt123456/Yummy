package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.OrderComm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:10 2019/2/26
 * @Description:
 */
@Repository
public interface OrderCommDAO extends JpaRepository<OrderComm, Integer> {

  List<OrderComm> findAllByOrderID(int orderID);

}
