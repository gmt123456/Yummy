package com.gaomt.yummy.service.user;

import com.gaomt.yummy.domain.Address;
import com.gaomt.yummy.domain.User;
import com.gaomt.yummy.repository.AddressDAO;
import com.gaomt.yummy.repository.UserDAO;
import com.gaomt.yummy.utils.UserLevelProperties;
import com.gaomt.yummy.vo.AddressVO;
import com.gaomt.yummy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:06 2019/2/25
 * @Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

  @Autowired
  private UserDAO userDAO;
  @Autowired
  private AddressDAO addressDAO;
  @Autowired
  private UserLevelProperties userLevelProperties;

  @Override
  public UserVO getUserInfo(int userID) {
    UserVO userInfoVO = new UserVO();

    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();
      String address = null;

      if (!(user.getAddrID() == null)) {
        if (addressDAO.findById(user.getAddrID()).isPresent()) {
          address = addressDAO.findById(user.getAddrID()).get().getAddress();
        }
      }
      userInfoVO.initByUser(user, address);
    }
    return userInfoVO;
  }

  @Override
  public AddressVO getUserDefAddr(int userID) {
    AddressVO addressVO = new AddressVO();

    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();

      if (user.getAddrID() == null) return null;

      if (addressDAO.findById(user.getAddrID()).isPresent()) {
        Address address = addressDAO.findById(user.getAddrID()).get();
        addressVO.initByAddress(address);
        return addressVO;
      }
    }
    return addressVO;
  }

  @Override
  public ArrayList<AddressVO> getUserAllAddr(int userID) {
    ArrayList<AddressVO> addressVOS = new ArrayList<>();
    if (!addressDAO.findAddressesByUserID(userID).isEmpty()) {
      ArrayList<Address> addresses = addressDAO.findAddressesByUserID(userID);
      AddressVO addressVO;

      for (int i = addresses.size() - 1; i >= 0; i--) {
        Address address = addresses.get(i);
        addressVO = new AddressVO();
        addressVO.initByAddress(address);
        addressVOS.add(addressVO);
      }
    }
    return addressVOS;
  }

  @Override
  public double getUserAmount(int userID) {
    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();
      return user.getAmount();
    }
    return 0;
  }

  @Override
  public String getUserNameByID(int userID) {
    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();
      return user.getName();
    }
    return null;
  }

  @Override
  public int getUserLevelByID(int userID) {
    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();
      return user.getLevel();
    }
    return -1;
  }

  @Override
  public int getCounts() {
    return userDAO.getCount();
  }

  @Override
  public double getLevelDiscount(int userID) {
    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();
      int level = user.getLevel();
      switch (level) {
        case 1:
          return userLevelProperties.getL1Discount() * 0.1;
        case 2:
          return userLevelProperties.getL2Discount() * 0.1;
        case 3:
          return userLevelProperties.getL3Discount() * 0.1;
        default:
          return 1;
      }
    }
    return 1;
  }
}
