package com.sell.sellproduct.repository;

import com.sell.sellproduct.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administratoron 2019/2/24
 **/
@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findAllByProductIdIn(List<String> productIdList);
}
