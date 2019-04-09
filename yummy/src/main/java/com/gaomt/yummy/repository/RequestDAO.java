package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 9:16 2019/2/26
 * @Description:
 */
@Repository
public interface RequestDAO extends JpaRepository<Request, Integer> {

  List<Request> findAllByResID(int resID);

  List<Request> findAllByResIDAndState(int resID, String state);

}
