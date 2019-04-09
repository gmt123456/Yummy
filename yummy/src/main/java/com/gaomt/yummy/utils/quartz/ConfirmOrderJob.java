package com.gaomt.yummy.utils.quartz;

import com.gaomt.yummy.service.order.OrderStateService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Author： MengtingGao
 * @Date： Create in 11:21 2019/2/28
 * @Description:
 */
public class ConfirmOrderJob implements Job {

  @Autowired
  private OrderStateService orderStateService;

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    Map<String, Object> argMap = jobExecutionContext.getTrigger().getJobDataMap();
    String orderID = argMap.get("orderID").toString();
    orderStateService.confirmDelivery(Integer.parseInt(orderID));
  }
}
