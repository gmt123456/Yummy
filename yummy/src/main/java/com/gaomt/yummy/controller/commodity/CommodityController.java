package com.gaomt.yummy.controller.commodity;

import com.gaomt.yummy.constant.CommodityType;
import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.service.commodity.CommodityService;
import com.gaomt.yummy.vo.CommodityVO;
import com.gaomt.yummy.vo.DiscountVO;
import com.gaomt.yummy.vo.PackageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Author： MengtingGao
 * @Date： Create in 21:48 2019/3/6
 * @Description:
 */
@RestController
@RequestMapping("/commodity")
@CrossOrigin("http://localhost:8010")
public class CommodityController {

  @Autowired
  private CommodityService commodityService;

  @RequestMapping(value = "/add/commodity", method = RequestMethod.POST)
  int addNewCommodity(@RequestParam(value = "resID") int resID,
                      @RequestParam(value = "name") String name,
                      @RequestParam(value = "price") double price,
                      @RequestParam(value = "count") int count,
                      @RequestParam(value = "imageData") String imageData) {
    return commodityService.addNewCommodity(resID, name, price, count, imageData);
  }

  @RequestMapping(value = "/set/time", method = RequestMethod.POST)
  CommonResult setCommodityTime(@RequestParam(value = "commID") int commID,
                                @RequestParam(value = "start") Date start,
                                @RequestParam(value = "end") Date end) {
    return commodityService.setCommodityTime(commID, start, end);
  }

  @RequestMapping(value = "/all", method = RequestMethod.POST)
  ArrayList<CommodityVO> getCommoditiesFromRes(@RequestParam(value = "resID") int resID,
                                               @RequestParam(value = "commodityType") String commodityType) {
    return commodityService.getCommoditiesFromRes(resID, CommodityType.valueOf(commodityType));
  }

  @RequestMapping(value = "/package", method = RequestMethod.POST)
  ArrayList<String> getCommNamesFromPkg(@RequestParam(value = "pkgID") int pkgID) {
    return commodityService.getPackageCommsName(pkgID);
  }

  @RequestMapping(value = "/current", method = RequestMethod.POST)
  ArrayList<CommodityVO> getCurrentCommoditiesFromRes(@RequestParam(value = "resID") int resID,
                                                      @RequestParam(value = "commodityType") String commodityType) {
    return commodityService.getCurrentCommoditiesFromRes(resID, CommodityType.valueOf(commodityType));
  }

  @RequestMapping(value = "/add/package", method = RequestMethod.POST)
  int addNewPackage(@RequestBody PackageVO vo) {
    return commodityService.addNewPackage(vo.getResID(), vo.getName(), vo.getPrice(), vo.getCount(), vo.getCommIDs(), vo.getImageData());
  }

  @RequestMapping(value = "/set/discount", method = RequestMethod.POST)
  CommonResult updateDiscounts(@RequestBody DiscountVO vo) {
    commodityService.updateDiscounts(vo.getCommIDs(), vo.getDiscount(), vo.getStart(), vo.getEnd());
    return CommonResult.SUCCESS;
  }

}
