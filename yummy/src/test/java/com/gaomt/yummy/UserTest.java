package com.gaomt.yummy;

import com.gaomt.yummy.YummyApplication;
import com.gaomt.yummy.service.user.UserAccessService;
import com.gaomt.yummy.service.user.UserInfoService;
import com.gaomt.yummy.service.user.UserModifyService;
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
 * @Date： Create in 14:55 2019/2/25
 * @Description:
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = YummyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {

  @Autowired
  private UserAccessService userAccessService;
  @Autowired
  private UserModifyService userModifyService;
  @Autowired
  private UserInfoService userInfoService;

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
