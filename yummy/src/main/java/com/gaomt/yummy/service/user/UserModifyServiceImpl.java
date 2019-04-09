package com.gaomt.yummy.service.user;

import com.gaomt.yummy.constant.AvatarType;
import com.gaomt.yummy.constant.CommonResult;
import com.gaomt.yummy.constant.PasswordResult;
import com.gaomt.yummy.constant.UserModifyType;
import com.gaomt.yummy.domain.Address;
import com.gaomt.yummy.domain.User;
import com.gaomt.yummy.repository.AddressDAO;
import com.gaomt.yummy.repository.UserDAO;
import com.gaomt.yummy.utils.ImageUtils;
import com.gaomt.yummy.utils.UserLevelProperties;
import com.gaomt.yummy.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author： MengtingGao
 * @Date： Create in 16:06 2019/2/25
 * @Description:
 */
@Service
public class UserModifyServiceImpl implements UserModifyService {

  @Autowired
  private UserDAO userDAO;
  @Autowired
  private AddressDAO addressDAO;
  @Autowired
  private UserLevelProperties levelProperties;

  @Override
  public CommonResult modifyUserNumber(int userID, String newNumber) {
    return modifyUserInfo(userID, UserModifyType.NUMBER, newNumber);
  }

  @Override
  public CommonResult modifyUserName(int userID, String newName) {
    return modifyUserInfo(userID, UserModifyType.NAME, newName);
  }

  @Override
  public CommonResult modifyUserDefAddr(int userID, int addrID) {
    return modifyUserInfo(userID, UserModifyType.DEF_ADDRESS, String.valueOf(addrID));
  }

  @Override
  public PasswordResult modifyUserPassword(int userID, String oldPassword, String newPassword) {
    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();

      if (user.getPassword().equals(oldPassword)) {
        user.setPassword(newPassword);
        userDAO.save(user);
        return PasswordResult.SUCCESS;
      }
      else return PasswordResult.PASSWORD_ERROR;
    }
    return PasswordResult.FAIL;
  }

  @Override
  public AddressVO addUserAddress(int userID, String address) {
    AddressVO addressVO = new AddressVO();
    boolean initDefAddress = false;
    if (addressDAO.findAddressesByUserID(userID).isEmpty()) initDefAddress = true;

    Address addressDo = new Address();
    addressDo.setAddress(address);
    addressDo.setUserID(userID);
    addressDAO.save(addressDo);

    if (initDefAddress) modifyUserDefAddr(userID, addressDo.getAddrID());

    addressVO.initByAddress(addressDo);

    return addressVO;
  }

  @Override
  public CommonResult modifyUserAddress(int userID, int addrID, String address) {
    if (addressDAO.findById(addrID).isPresent()) {
      Address addressDo = addressDAO.findById(addrID).get();
      addressDo.setAddress(address);
      addressDAO.save(addressDo);
      return CommonResult.SUCCESS;
    }
    return CommonResult.FAIL;
  }

  @Override
  public void addUserCount(int userID) {
    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();
      int count = user.getCount() + 1;
      double amount = user.getAmount();
      user.setCount(count);

      double upAmount1 = levelProperties.getL1Amount();
      int upCount1 = levelProperties.getL1Count();
      double upAmount2 = levelProperties.getL2Amount();
      int upCount2 = levelProperties.getL2Count();
      double upAmount3 = levelProperties.getL3Amount();
      int upCount3 = levelProperties.getL3Count();

      if (count >= upCount3 || amount >= upAmount3) {
        user.setLevel(3);
      }
      else if (count >= upCount2 || amount >= upAmount2) {
        user.setLevel(2);
      }
      else if (count >= upCount1 || amount >= upAmount1) {
        user.setLevel(1);
      }
      else user.setLevel(0);

      userDAO.save(user);
    }
  }

  @Override
  public CommonResult modifyUserAvatar(int userID, String imageData) {
    String avatar;
    try {
      avatar = ImageUtils.transferImageTo(imageData, AvatarType.USER);
    } catch (Exception e) {
      e.printStackTrace();
      return CommonResult.FAIL;
    }

    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();
      user.setAvatar(avatar);
      userDAO.save(user);
      return CommonResult.SUCCESS;
    }
    else return CommonResult.FAIL;
  }

  private CommonResult modifyUserInfo(int userID, UserModifyType type, String newInfo) {
    if (userDAO.findById(userID).isPresent()) {
      User user = userDAO.findById(userID).get();

      switch (type) {
        case NAME:
          user.setName(newInfo);
          break;
        case NUMBER:
          user.setNumbers(newInfo);
          break;
        case DEF_ADDRESS:
          user.setAddrID(Integer.parseInt(newInfo));
          break;
      }

      userDAO.save(user);
      return CommonResult.SUCCESS;
    }
    return CommonResult.FAIL;
  }

}
