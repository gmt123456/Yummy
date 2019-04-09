package com.gaomt.yummy.service.resaurant;

import com.gaomt.yummy.vo.ResaurantTypeVO;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 10:56 2019/2/26
 * @Description:
 */
public interface ResaurantTypeService {

  ArrayList<ResaurantTypeVO> getAllResaurantType();

  String getResaurantTypeNameByID(int resTypeID);

  int getResaurantTypeIDByName(String resTypeName);
}
