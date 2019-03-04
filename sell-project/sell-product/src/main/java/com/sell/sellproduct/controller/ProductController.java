package com.sell.sellproduct.controller;

import com.sell.sellproduct.entity.ProductCategory;
import com.sell.sellproduct.entity.ProductInfo;
import com.sell.sellproduct.service.ProductCategoryService;
import com.sell.sellproduct.service.ProductInfoService;
import com.sell.sellproduct.utils.ResultVOUtil;
import com.sell.sellproduct.vo.ProductInfoVO;
import com.sell.sellproduct.vo.ProductVO;
import com.sell.sellproduct.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administratoron 2019/2/24
 **/
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 获取所有的商品类目，以及该类目下所有在架的商品
     * @return
     */
    @RequestMapping(value = "/list")
    public ResultVO list() {

        // 1、查询所有在架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        // 2、获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        // 3、从数据库查询类目
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        // 4、构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setFoods(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
