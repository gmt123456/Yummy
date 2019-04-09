package com.gaomt.yummy;

import com.gaomt.yummy.constant.AvatarType;
import com.gaomt.yummy.constant.OrderState;
import com.gaomt.yummy.constant.PayResult;
import com.gaomt.yummy.service.order.OrderInfoService;
import com.gaomt.yummy.service.order.OrderStateService;
import com.gaomt.yummy.service.record.RecordService;
import com.gaomt.yummy.service.request.RequestService;
import com.gaomt.yummy.utils.ImageUtils;
import com.sun.imageio.plugins.common.ImageUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author： MengtingGao
 * @Date： Create in 14:36 2019/2/27
 * @Description:
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = YummyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ResaurantTest { // email, user, commodity, resaurant, order, record, request

  @Autowired
  private RequestService requestService;
  private static int count = 1;

  @Test
  public void a() {

  }

  private void printEnum(Object o) {
    System.out.println(count +": "+ o.toString());
    count++;
  }

  private void printObject(Object o) {
    System.out.println(count +": "+ JSONObject.fromObject(o));
    count++;
  }

  private void printArray(Object o) {
    System.out.println(count +": "+ JSONArray.fromObject(o));
    count++;
  }

}
