package com.gaomt.yummy.service.resaurant;

import com.gaomt.yummy.constant.LoginResult;
import com.gaomt.yummy.domain.Resaurant;
import com.gaomt.yummy.vo.ResaurantVO;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 21:22 2019/2/25
 * @Description:
 */
public interface ResaurantService {

  int register(String password);

  LoginResult login(int resID, String password);

  ResaurantVO getResInfo(int resID);

  Resaurant getResaurantByID(int resID);

  String getNameByID(int resID);

  void modifyResLocate(int resID, String newLocate);

  void modifyResType(int resID, String newTypeName);

  void modifyResName(int resID, String newName);

  ArrayList<ResaurantVO> getRecResaurant(int count, int pageStart);

  void setResLocate(int resID, String newLocate);

  void setResType(int resID, String newTypeName);

  void setResName(int resID, String newName);

  void setAvatar(int resID, String imageData);

  void earn(int resID, double amount);

  double getAllAmount();

  void settle(double discount);

  int getCounts();

}
