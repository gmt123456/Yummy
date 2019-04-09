package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @Author： MengtingGao
 * @Date： Create in 15:44 2019/2/25
 * @Description:
 */
@Repository
public interface AddressDAO extends JpaRepository<Address, Integer>{

  ArrayList<Address> findAddressesByUserID(Integer userID);

}
