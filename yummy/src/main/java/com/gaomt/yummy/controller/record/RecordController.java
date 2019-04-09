package com.gaomt.yummy.controller.record;

import com.gaomt.yummy.constant.RecordType;
import com.gaomt.yummy.service.record.RecordService;
import com.gaomt.yummy.vo.RecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 21:23 2019/3/6
 * @Description:
 */
@RestController
@RequestMapping("/record")
@CrossOrigin("http://localhost:8010")
public class RecordController {

  @Autowired
  private RecordService recordService;

  @RequestMapping(value = "/amount", method = RequestMethod.POST)
  ArrayList<Double> getOrderAmountList() {
    return recordService.getOrderAmountList();
  }

  @RequestMapping(value = "/restaurant", method = RequestMethod.POST)
  ArrayList<RecordVO> getOrdersByResAndType(@RequestParam(value = "resID") int resID,
                                            @RequestParam(value = "recType") String recType) {
    return recordService.getRecordByResAndType(resID, RecordType.valueOf(recType));
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  ArrayList<RecordVO> getOrdersByUserAndType(@RequestParam(value = "userID") int userID,
                                             @RequestParam(value = "recType") String recType) {
    return recordService.getRecordByUserAndType(userID, RecordType.valueOf(recType));
  }

  @RequestMapping(value = "/finish", method = RequestMethod.POST)
  double getFinishAmount() {
    return recordService.getFinishAmount();
  }

  @RequestMapping(value = "/settle", method = RequestMethod.POST)
  double getSettleAmount() {
    return recordService.getSettleAmount();
  }

}
