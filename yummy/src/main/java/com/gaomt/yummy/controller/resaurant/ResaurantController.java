package com.gaomt.yummy.controller.resaurant;

import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.constant.LoginResult;
import com.gaomt.yummy.service.resaurant.ResaurantService;
import com.gaomt.yummy.service.resaurant.ResaurantTypeService;
import com.gaomt.yummy.vo.ResaurantTypeVO;
import com.gaomt.yummy.vo.ResaurantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 17:16 2019/3/6
 * @Description:
 */
@RestController
@RequestMapping("/restaurant")
@CrossOrigin("http://localhost:8010")
public class ResaurantController {

  @Autowired
  private ResaurantService resaurantService;

  @Autowired
  private ResaurantTypeService resaurantTypeService;

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  int register(@RequestParam(value = "password") String password) {
    return resaurantService.register(password);
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  LoginResult login(@RequestParam(value = "resID") int resID,
                    @RequestParam(value = "password") String password){
    return resaurantService.login(resID, password);
  }

  @RequestMapping(value = "/info", method = RequestMethod.POST)
  ResaurantVO getResInfo(@RequestParam(value = "resID") int resID){
    return resaurantService.getResInfo(resID);
  }

  @RequestMapping(value = "/modify/locate", method = RequestMethod.POST)
  CommonResult modifyResLocate(@RequestParam(value = "resID") int resID,
                               @RequestParam(value = "newLocate") String newLocate){
    resaurantService.modifyResLocate(resID, newLocate);
    return CommonResult.SUCCESS;
  }

  @RequestMapping(value = "/modify/type", method = RequestMethod.POST)
  CommonResult modifyResType(@RequestParam(value = "resID") int resID,
                     @RequestParam(value = "newTypeName") String newTypeName){
    resaurantService.modifyResType(resID, newTypeName);
    return CommonResult.SUCCESS;
  }

  @RequestMapping(value = "/modify/name", method = RequestMethod.POST)
  CommonResult modifyResName(@RequestParam(value = "resID") int resID,
                     @RequestParam(value = "newName") String newName){
    resaurantService.modifyResName(resID, newName);
    return CommonResult.SUCCESS;
  }

  @RequestMapping(value = "/recommend", method = RequestMethod.POST)
  ArrayList<ResaurantVO> getRecResaurant(@RequestParam(value = "count") int count,
                                         @RequestParam(value = "pageStart") int pageStart){
    return resaurantService.getRecResaurant(count, pageStart);
  }

  @RequestMapping(value = "/modify/avatar", method = RequestMethod.POST)
  CommonResult setAvatar(@RequestParam(value = "resID") int resID,
                 @RequestParam(value = "imageData") String imageData){
    resaurantService.setAvatar(resID, imageData);
    return CommonResult.SUCCESS;
  }

  @RequestMapping(value = "/amount", method = RequestMethod.POST)
  double getAllAmount(){
    return resaurantService.getAllAmount();
  }

  @RequestMapping(value = "/settle", method = RequestMethod.POST)
  CommonResult settle(@RequestParam(value = "discount") double discount){
    resaurantService.settle(discount);
    return CommonResult.SUCCESS;
  }

  @RequestMapping(value = "/type", method = RequestMethod.POST)
  ArrayList<ResaurantTypeVO> getAllResaurantType() {
    return resaurantTypeService.getAllResaurantType();
  }

  @RequestMapping(value = "/count", method = RequestMethod.POST)
  int getCounts() {
    return resaurantService.getCounts();
  }
}
