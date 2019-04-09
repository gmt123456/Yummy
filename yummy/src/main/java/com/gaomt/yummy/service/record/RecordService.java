package com.gaomt.yummy.service.record;

import com.gaomt.yummy.constant.RecordType;
import com.gaomt.yummy.vo.RecordVO;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 10:58 2019/2/27
 * @Description:
 */
public interface RecordService {

  void addRecord(RecordType recordType, Timestamp time, double amount, int resID, int userID, int orderID);

  ArrayList<RecordVO> getRecordByUser(int userID);

  ArrayList<RecordVO> getRecordByResAndType(int resID, RecordType type);

  ArrayList<RecordVO> getRecordByUserAndType(int userID, RecordType type);

  ArrayList<Double> getOrderAmountList();

  double getFinishAmount();

  double getSettleAmount();

}
