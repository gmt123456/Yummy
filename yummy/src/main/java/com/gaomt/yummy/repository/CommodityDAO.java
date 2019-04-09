package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 19:33 2019/2/25
 * @Description:
 */
public interface CommodityDAO extends JpaRepository<Commodity, Integer> {

  List<Commodity> findCommoditiesByResIDAndCommType(int resID, String commType);

}
