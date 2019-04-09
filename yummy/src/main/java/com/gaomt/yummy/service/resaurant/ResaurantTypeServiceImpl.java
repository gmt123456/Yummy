package com.gaomt.yummy.service.resaurant;

import com.gaomt.yummy.domain.ResaurantType;
import com.gaomt.yummy.repository.ResaurantTypeDAO;
import com.gaomt.yummy.vo.ResaurantTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 11:00 2019/2/26
 * @Description:
 */
@Service
public class ResaurantTypeServiceImpl implements ResaurantTypeService {

  @Autowired
  private ResaurantTypeDAO resaurantTypeDAO;

  @Override
  public ArrayList<ResaurantTypeVO> getAllResaurantType() {
    ArrayList<ResaurantTypeVO> resaurantTypeVOS = new ArrayList<>();
    List<ResaurantType> resaurantTypes = resaurantTypeDAO.findAll();
    ResaurantTypeVO resaurantTypeVO;

    for (ResaurantType resaurantType: resaurantTypes) {
      resaurantTypeVO = new ResaurantTypeVO();
      resaurantTypeVO.initByResaurantType(resaurantType);
      resaurantTypeVOS.add(resaurantTypeVO);
    }
    return resaurantTypeVOS;
  }

  @Override
  public String getResaurantTypeNameByID(int resTypeID) {
    if (resaurantTypeDAO.findById(resTypeID).isPresent()) {
      ResaurantType resaurantType = resaurantTypeDAO.findById(resTypeID).get();
      return resaurantType.getTypeName();
    }
    else return null;
  }

  @Override
  public int getResaurantTypeIDByName(String resTypeName) {
    ResaurantType resaurantType = resaurantTypeDAO.findByTypeName(resTypeName);
    if (resaurantType == null) return 0;
    else return resaurantType.getResTypeID();
  }
}
