package com.sell.sellproduct.service.impl;

import com.sell.sellproduct.dto.CartDTO;
import com.sell.sellproduct.entity.ProductInfo;
import com.sell.sellproduct.enums.ProductExceptionEnum;
import com.sell.sellproduct.enums.ProductInfoStatusEnum;
import com.sell.sellproduct.exception.ProductException;
import com.sell.sellproduct.repository.ProductInfoRepository;
import com.sell.sellproduct.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administratoron 2019/2/24
 **/
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 查询所有在架的商品信息
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {

        return productInfoRepository.findByProductStatus(ProductInfoStatusEnum.UP.getCode());
    }

    /**
     * 根据商品id集合查询商品详情
     * @param productIdList
     * @return
     */
    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findAllByProductIdIn(productIdList);
    }

    /**
     * 扣库存
     * @param cartDTOList：订单中的商品列表
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for(CartDTO cartDTO : cartDTOList) {

            // 获取商品详情，springboot2.0以后，findById方法返回的是Optional对象
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            // 判断商品是否存在，如果商品不存在，就抛出商品不存在的异常
            if(!productInfoOptional.isPresent()) {
                throw new ProductException(ProductExceptionEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            // 判断商品库存是否充足，如果商品库存不足，就抛出商品库存不足的异常
            if(result < 0) {
                throw new ProductException(ProductExceptionEnum.PRODUCT_STOCK_SHORT);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
