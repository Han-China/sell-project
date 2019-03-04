package com.sell.product.server.repository;

import com.sell.product.entity.ProductInfo;
import com.sell.product.repository.ProductInfoRepository;
import com.sell.product.server.ServerApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administratoron 2019/3/2
 **/
@Component
public class ProductInfoRepositoryTest extends ServerApplicationTests {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findAllByProductIdIn() {

        List<ProductInfo> list = productInfoRepository.findAllByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue( list.size() == 2);
    }
}