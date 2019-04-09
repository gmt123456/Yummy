package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.Inbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author： MengtingGao
 * @Date： Create in 9:26 2019/2/26
 * @Description:
 */
@Repository
public interface InboxDAO extends JpaRepository<Inbox, Integer> {

  void deleteByReqID(int reqID);

}
