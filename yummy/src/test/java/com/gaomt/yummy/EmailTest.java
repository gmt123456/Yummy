package com.gaomt.yummy;

import com.gaomt.yummy.service.email.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author： MengtingGao
 * @Date： Create in 17:33 2019/2/24
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = YummyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmailTest {

  @Autowired
  private EmailService emailService;

}