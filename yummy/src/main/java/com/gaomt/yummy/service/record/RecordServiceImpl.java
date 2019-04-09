package com.gaomt.yummy.service.record;

import com.gaomt.yummy.constant.RecordType;
import com.gaomt.yummy.domain.Record;
import com.gaomt.yummy.repository.RecordDAO;
import com.gaomt.yummy.service.user.UserInfoService;
import com.gaomt.yummy.vo.RecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 11:06 2019/2/27
 * @Description:
 */
@Service
public class RecordServiceImpl implements RecordService {

  @Autowired
  private RecordDAO recordDAO;
  @Autowired
  private UserInfoService userInfoService;

  @Override
  public void addRecord(RecordType recordType, Timestamp time, double amount, int resID, int userID, int orderID) {
    Record record = new Record();
    record.setAmount(amount);
    record.setOrderID(orderID);
    record.setRecType(recordType.toString());
    record.setResID(resID);
    record.setTime(time);
    record.setUserID(userID);
    record.setLevel(userInfoService.getUserLevelByID(userID));
    recordDAO.save(record);
  }

  @Override
  public ArrayList<RecordVO> getRecordByUser(int userID) {
    List<Record> records = recordDAO.findRecordsByUserID(userID);
    ArrayList<RecordVO> recordVOS = new ArrayList<>();

    for (Record record: records) {
      RecordVO recordVO = new RecordVO();
      recordVO.initByRecord(record);
      recordVOS.add(recordVO);
    }
    return recordVOS;
  }

  @Override
  public ArrayList<RecordVO> getRecordByResAndType(int resID, RecordType type) {
    List<Record> records = recordDAO.findRecordsByResIDAndRecType(resID, type.toString());
    ArrayList<RecordVO> recordVOS = new ArrayList<>();

    for (Record record: records) {
      RecordVO recordVO = new RecordVO();
      recordVO.initByRecord(record);
      recordVOS.add(recordVO);
    }
    return recordVOS;
  }

  @Override
  public ArrayList<RecordVO> getRecordByUserAndType(int userID, RecordType type) {
    List<Record> records = recordDAO.findRecordsByUserIDAndRecType(userID, type.toString());
    ArrayList<RecordVO> recordVOS = new ArrayList<>();

    for (Record record: records) {
      RecordVO recordVO = new RecordVO();
      recordVO.initByRecord(record);
      recordVOS.add(recordVO);
    }
    return recordVOS;
  }

  @Override
  public ArrayList<Double> getOrderAmountList() {
    return recordDAO.getOrderAmountList();
  }

  @Override
  public double getFinishAmount() {
    if (recordDAO.getFinishAmount() == null) return 0.0;
    else return recordDAO.getFinishAmount();
  }

  @Override
  public double getSettleAmount() {
    if (recordDAO.getSettleAmount() == null) return 0.0;
    else return recordDAO.getSettleAmount();
  }
}
