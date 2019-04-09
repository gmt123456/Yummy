package com.gaomt.yummy.repository;

import com.gaomt.yummy.domain.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author： MengtingGao
 * @Date： Create in 20:55 2019/2/25
 * @Description:
 */
@Repository
public interface PackageDAO extends JpaRepository<Package, Integer> {

  List<Package> findPackagesByPkgID(int pkgID);

}
