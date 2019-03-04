package com.sell.sellproduct.service;

import com.sell.sellproduct.entity.ProductCategory;

import java.util.List;

/**
 * Created by Administratoron 2019/2/24
 **/
public interface ProductCategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
