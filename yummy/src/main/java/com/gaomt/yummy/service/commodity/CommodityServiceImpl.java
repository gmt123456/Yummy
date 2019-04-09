package com.gaomt.yummy.service.commodity;

import com.gaomt.yummy.constant.AvatarType;
import com.gaomt.yummy.constant.CommodityType;
import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.domain.Commodity;
import com.gaomt.yummy.domain.Package;
import com.gaomt.yummy.repository.CommodityDAO;
import com.gaomt.yummy.repository.PackageDAO;
import com.gaomt.yummy.utils.ImageUtils;
import com.gaomt.yummy.vo.CommodityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 19:32 2019/2/25
 * @Description:
 */
@Service
public class CommodityServiceImpl implements CommodityService {

  @Autowired
  private CommodityDAO commodityDAO;
  @Autowired
  private PackageDAO packageDAO;

  @Override
  public int addNewCommodity(int resID, String name, double price, int count, String imageData) {
    return addNewCommodityByType(resID, name, price, count, CommodityType.COMMODITY.toString(), imageData);
  }

  @Override
  public ArrayList<CommodityVO> getCommoditiesFromRes(int resID, CommodityType commodityType) {
    ArrayList<CommodityVO> commodityVOS = new ArrayList<>();
    List<Commodity> commodities = commodityDAO.findCommoditiesByResIDAndCommType(resID, commodityType.toString());
    CommodityVO commodityVO;
    for (Commodity commodity: commodities) {
      commodityVO = new CommodityVO();
      commodityVO.initByCommodity(commodity);
      commodityVOS.add(commodityVO);
    }
    return commodityVOS;
  }

  @Override
  public ArrayList<CommodityVO> getCurrentCommoditiesFromRes(int resID, CommodityType commodityType) {
    ArrayList<CommodityVO> commodityVOS = new ArrayList<>();
    List<Commodity> commodities = commodityDAO.findCommoditiesByResIDAndCommType(resID, commodityType.toString());
    CommodityVO commodityVO;
    for (Commodity commodity: commodities) {
      if (commodity.getStart() != null && compareDate(commodity.getStart(), commodity.getEnd())) {
        commodityVO = new CommodityVO();
        commodityVO.initByCommodity(commodity);
        commodityVOS.add(commodityVO);
      }
    }
    return commodityVOS;
  }

  @Override
  public int addNewPackage(int resID, String name, double price, int count, ArrayList<Integer> commIDs, String imageData) {
    int pkgID = addNewCommodityByType(resID, name, price, count, CommodityType.PACKAGE.toString(), imageData);
    Package pkg;
    for (int commID: commIDs) {
      pkg = new Package();
      pkg.setPkgID(pkgID);
      pkg.setCommID(commID);
      packageDAO.save(pkg);
    }
    return pkgID;
  }

  @Override
  public CommonResult setCommodityTime(int commID, Date start, Date end) {
    if (commodityDAO.findById(commID).isPresent()) {
      Commodity commodity = commodityDAO.findById(commID).get();
      commodity.setStart(new java.sql.Date(start.getTime()));
      commodity.setEnd(new java.sql.Date(end.getTime()));
      commodityDAO.save(commodity);
      return CommonResult.SUCCESS;
    }
    return CommonResult.FAIL;
  }

  @Override
  public void updateDiscounts(ArrayList<Integer> commIDs, double discount, Date start, Date end) {
    for (int commID: commIDs) {
      if (commodityDAO.findById(commID).isPresent()) {
        Commodity commodity = commodityDAO.findById(commID).get();
        commodity.setDiscStart(new java.sql.Date(start.getTime()));
        commodity.setDiscEnd(new java.sql.Date(end.getTime()));
        commodity.setDiscount(discount);
        commodityDAO.save(commodity);
      }
    }
  }

  @Override
  public ArrayList<String> getPackageCommsName(int pkgID) {
    List<Package> packages = packageDAO.findPackagesByPkgID(pkgID);
    ArrayList<String> names = new ArrayList<>();

    for (Package pkg: packages) {
      int commID = pkg.getCommID();
      if (commodityDAO.findById(commID).isPresent()) {
        names.add(commodityDAO.findById(commID).get().getName());
      }
      else break;
    }
    return names;
  }

  @Override
  public CommonResult reduceCount(int commID, int count) {
    if (commodityDAO.findById(commID).isPresent()) {
      Commodity commodity = commodityDAO.findById(commID).get();
      int commCount = commodity.getCount();
      if (commCount - count < 0) return CommonResult.FAIL;
      commodity.setCount(commCount - count);
      commodityDAO.save(commodity);
      return CommonResult.SUCCESS;
    }
    else return CommonResult.FAIL;
  }

  @Override
  public void addCount(int commID, int count) {
    if (commodityDAO.findById(commID).isPresent()) {
      Commodity commodity = commodityDAO.findById(commID).get();
      int commCount = commodity.getCount();
      commodity.setCount(commCount + count);
      commodityDAO.save(commodity);
    }
  }

  private boolean compareDate(Date start, Date end) {
    Date today = new Date(System.currentTimeMillis());
    LocalDate localDateStart = ZonedDateTime.ofInstant(new Date(start.getTime()).toInstant(), ZoneId.systemDefault()).toLocalDate();
    LocalDate localDateEnd = ZonedDateTime.ofInstant(new Date(end.getTime()).toInstant(), ZoneId.systemDefault()).toLocalDate();
    LocalDate localDateToday = ZonedDateTime.ofInstant(today.toInstant(), ZoneId.systemDefault()).toLocalDate();

    if (localDateStart.isAfter(localDateToday)) return false;
    if (localDateEnd.isBefore(localDateToday)) return false;

    return true;
  }

  private int addNewCommodityByType(int resID, String name, double price, int count, String commType, String imageData) {
    Commodity commodity = new Commodity();
    commodity.setResID(resID);
    commodity.setName(name);
    commodity.setPrice(price);
    commodity.setCount(count);
    commodity.setCommType(commType);

    String avatar;
    try {
      avatar = ImageUtils.transferImageTo(imageData, AvatarType.COMMODITY);
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }

    commodity.setAvatar(avatar);

    commodityDAO.save(commodity);
    return commodity.getCommID();
  }
}
