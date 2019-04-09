package com.gaomt.yummy.service.commodity;

import com.gaomt.yummy.constant.CommodityType;
import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.vo.CommodityVO;

import java.util.Date;
import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 19:09 2019/2/25
 * @Description:
 */
public interface CommodityService {

  int addNewCommodity(int resID, String name, double price, int count, String imageData);

  CommonResult setCommodityTime(int commID, Date start, Date end);

  ArrayList<CommodityVO> getCommoditiesFromRes(int resID, CommodityType commodityType);

  ArrayList<CommodityVO> getCurrentCommoditiesFromRes(int resID, CommodityType commodityType);

  int addNewPackage(int resID, String name, double price, int count, ArrayList<Integer> commIDs, String imageData);

  void updateDiscounts(ArrayList<Integer> commIDs, double discount, Date start, Date end);

  ArrayList<String> getPackageCommsName(int pkgID);

  CommonResult reduceCount(int commID, int count);

  void addCount(int commID, int count);

}
