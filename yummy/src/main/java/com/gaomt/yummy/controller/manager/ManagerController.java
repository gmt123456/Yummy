package com.gaomt.yummy.controller.manager;

import com.gaomt.yummy.constant.LoginResult;
import com.gaomt.yummy.service.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author： MengtingGao
 * @Date： Create in 21:39 2019/3/6
 * @Description:
 */
@RestController
@RequestMapping("/manager")
@CrossOrigin("http://localhost:8010")
public class ManagerController {

  @Autowired
  private ManagerService managerService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  LoginResult login(@RequestParam(value = "managerID") int managerID,
                    @RequestParam(value = "password") String password) {
    return managerService.login(managerID, password);
  }

}
