package com.sell.sellproduct.service.impl;

import com.sell.sellproduct.entity.ProductCategory;
import com.sell.sellproduct.repository.ProductCategoryRepository;
import com.sell.sellproduct.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administratoron 2019/2/24
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {

        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
