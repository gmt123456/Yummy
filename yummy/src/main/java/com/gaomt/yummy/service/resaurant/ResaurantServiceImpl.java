package com.gaomt.yummy.service.resaurant;

import com.gaomt.yummy.constant.AvatarType;
import com.gaomt.yummy.constant.LoginResult;
import com.gaomt.yummy.constant.RecordType;
import com.gaomt.yummy.constant.RequestType;
import com.gaomt.yummy.domain.Resaurant;
import com.gaomt.yummy.repository.ResaurantDAO;
import com.gaomt.yummy.service.account.AccountService;
import com.gaomt.yummy.service.record.RecordService;
import com.gaomt.yummy.service.request.RequestService;
import com.gaomt.yummy.utils.ImageUtils;
import com.gaomt.yummy.vo.ResaurantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 21:22 2019/2/25
 * @Description:
 */
@Service
@Transactional
public class ResaurantServiceImpl implements ResaurantService {

  @Autowired
  private ResaurantDAO resaurantDAO;
  @Autowired
  private ResaurantTypeService resaurantTypeService;
  @Autowired
  private RequestService requestService;
  @Autowired
  private AccountService accountService;
  @Autowired
  private RecordService recordService;

  @Override
  public int register(String password) {
    Resaurant resaurant = new Resaurant();
    resaurant.setPassword(password);
    resaurantDAO.save(resaurant);
    resaurant.setName("R_" + resaurant.getResID());
    resaurantDAO.save(resaurant);
    return resaurant.getResID();
  }

  @Override
  public LoginResult login(int resID, String password) {
    if (resaurantDAO.findById(resID).isPresent()) {
      Resaurant resaurant = resaurantDAO.findById(resID).get();
      if (resaurant.getPassword().equals(password)) return LoginResult.SUCCESS;
      else return LoginResult.PASSWORD_ERROR;
    }
    else return LoginResult.ID_ERROR;
  }

  @Override
  public ResaurantVO getResInfo(int resID) {
    ResaurantVO resaurantVO = new ResaurantVO();
    if (getResaurantByID(resID) == null) return null;
    else {
      Resaurant resaurant = getResaurantByID(resID);
      String resTypeName = resaurantTypeService.getResaurantTypeNameByID(resaurant.getResTypeID());
      resaurantVO.initByResaurant(resaurant, resTypeName);
      return resaurantVO;
    }
  }

  @Override
  public Resaurant getResaurantByID(int resID) {
    if (resaurantDAO.findById(resID).isPresent()) return resaurantDAO.findById(resID).get();
    else return null;
  }

  @Override
  public String getNameByID(int resID) {
    if (resaurantDAO.findById(resID).isPresent()) return resaurantDAO.findById(resID).get().getName();
    else return null;
  }

  @Override
  public void modifyResLocate(int resID, String newLocate) {
    requestService.sendNewRequest(resID, RequestType.LOCATE, newLocate);
  }

  @Override
  public void modifyResType(int resID, String newTypeName) {
    requestService.sendNewRequest(resID, RequestType.TYPE, newTypeName);
  }

  @Override
  public void modifyResName(int resID, String newName) {
    requestService.sendNewRequest(resID, RequestType.NAME, newName);
  }

  @Override
  public ArrayList<ResaurantVO> getRecResaurant(int count, int pageStart) {
    ArrayList<ResaurantVO> resaurantVOS = new ArrayList<>();
    List<Resaurant> resaurants = resaurantDAO.findAll(PageRequest.of(pageStart, count)).getContent();
    ResaurantVO resaurantVO;

    for (Resaurant resaurant: resaurants) {
      resaurantVO = new ResaurantVO();
      String resTypeName = resaurantTypeService.getResaurantTypeNameByID(resaurant.getResTypeID());
      resaurantVO.initByResaurant(resaurant, resTypeName);
      resaurantVOS.add(resaurantVO);
    }
    return resaurantVOS;
  }

  @Override
  public void setResLocate(int resID, String newLocate) {
    setResInfo(resID, newLocate, RequestType.LOCATE);
  }

  @Override
  public void setResType(int resID, String newTypeName) {
    setResInfo(resID, newTypeName, RequestType.TYPE);
  }

  @Override
  public void setResName(int resID, String newName) {
    setResInfo(resID, newName, RequestType.NAME);
  }

  @Override
  public void setAvatar(int resID, String imageData) {
    String avatar;
    try {
      avatar = ImageUtils.transferImageTo(imageData, AvatarType.RESAURANT);
      if (resaurantDAO.findById(resID).isPresent()) {
        Resaurant resaurant = resaurantDAO.findById(resID).get();
        resaurant.setAvatar(avatar);
        resaurantDAO.save(resaurant);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void earn(int resID, double amount) {
    if (resaurantDAO.findById(resID).isPresent()) {
      Resaurant resaurant = resaurantDAO.findById(resID).get();
      resaurant.setAmount(resaurant.getAmount() + amount);
      resaurantDAO.save(resaurant);
    }
  }

  @Override
  public double getAllAmount() {
    return resaurantDAO.getSumAmount();
  }

  @Override
  public void settle(double discount) {
    double total = resaurantDAO.getSumAmount();
    resaurantDAO.settle(discount);
    accountService.pay(total * discount);
    recordService.addRecord(RecordType.SETTLE, new Timestamp(new Date().getTime()), total * discount, 0, 0, 0);
  }

  @Override
  public int getCounts() {
    return resaurantDAO.getCount();
  }

  private void setResInfo(int resID, String newResInfo, RequestType type) {
    if (resaurantDAO.findById(resID).isPresent()) {
      Resaurant resaurant = resaurantDAO.findById(resID).get();

      switch (type) {
        case LOCATE:
          resaurant.setLocate(newResInfo);
          break;
        case TYPE:
          resaurant.setResTypeID(resaurantTypeService.getResaurantTypeIDByName(newResInfo));
          break;
        case NAME:
          resaurant.setName(newResInfo);
          break;
      }
      resaurantDAO.save(resaurant);
    }
  }
}
