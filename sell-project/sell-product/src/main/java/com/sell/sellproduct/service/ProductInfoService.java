package com.sell.sellproduct.service;

import com.sell.sellproduct.dto.CartDTO;
import com.sell.sellproduct.entity.ProductInfo;

import java.util.List;

/**
 * Created by Administratoron 2019/2/24
 **/
public interface ProductInfoService {

    /**
     * 查询所有在架的商品信息
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 根据商品id集合查询商品详情
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList：订单中的商品列表
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
