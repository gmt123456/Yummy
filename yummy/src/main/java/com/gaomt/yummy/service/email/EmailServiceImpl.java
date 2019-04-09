package com.gaomt.yummy.service.email;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.domain.Email;
import com.gaomt.yummy.repository.EmailDAO;
import com.gaomt.yummy.utils.EmailCode;
import com.gaomt.yummy.utils.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @Author： MengtingGao
 * @Date： Create in 14:15 2019/2/24
 * @Description:
 */
@Service
public class EmailServiceImpl implements EmailService {

  @Autowired
  private EmailDAO emailDAO;
  @Autowired
  private JavaMailSender javaMailSender;
  @Autowired
  private MailProperties mailProperties;

  @Override
  public void sendEmailCode(String email) {
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    EmailCode emailCode = new EmailCode();
    String code = emailCode.getRandomCode(Integer.parseInt(mailProperties.getLength()));

    mailMessage.setFrom(mailProperties.getFrom());
    mailMessage.setTo(email);
    mailMessage.setSubject(mailProperties.getSubject());
    mailMessage.setText(code);

    javaMailSender.send(mailMessage);

    Email oldEmail = emailDAO.findByEmail(email);
    if (oldEmail == null) {
      Email emailDo = new Email();
      emailDo.setEmail(email);
      emailDo.setCode(code);
      emailDAO.save(emailDo);
    }
    else {
      oldEmail.setCode(code);
      emailDAO.save(oldEmail);
    }
  }

  @Override
  public CommonResult confirmEmailCode(String email, String code) {
    Email emailDo = emailDAO.findByEmail(email);
    if (emailDo == null) {
      return CommonResult.FAIL;
    }
    else {
      if (code.equals(emailDo.getCode())) {
        return CommonResult.SUCCESS;
      } else return CommonResult.FAIL;
    }
  }

}
