package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 11:05 2019/2/27
 * @Description:
 */
@Repository
public interface RecordDAO extends JpaRepository<Record, Integer> {

  List<Record> findRecordsByUserID(int userID);

  List<Record> findRecordsByResIDAndRecType(int resID, String recType);

  List<Record> findRecordsByUserIDAndRecType(int userID, String recType);

  @Query(nativeQuery = true, value = "SELECT amount FROM record WHERE rec_type='ORDER'")
  ArrayList<Double> getOrderAmountList();

  @Query(nativeQuery = true, value = "SELECT SUM(amount) FROM record WHERE rec_type='FINISH'")
  Double getFinishAmount();

  @Query(nativeQuery = true, value = "SELECT SUM(amount) FROM record WHERE rec_type='SETTLE'")
  Double getSettleAmount();
}
