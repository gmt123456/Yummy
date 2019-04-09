package com.gaomt.yummy.vo;

import com.gaomt.yummy.domain.Address;

/**
 * @Author： MengtingGao
 * @Date： Create in 8:22 2019/2/25
 * @Description:
 */
public class AddressVO {

  private int addrID;
  private String address;

  public void initByAddress(Address address) {
    addrID = address.getAddrID();
    this.address = address.getAddress();
  }

  public int getAddrID() {
    return addrID;
  }

  public void setAddrID(int addrID) {
    this.addrID = addrID;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
