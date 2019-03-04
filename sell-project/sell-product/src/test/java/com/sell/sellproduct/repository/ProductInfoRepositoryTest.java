package com.sell.sellproduct.repository;

import com.sell.sellproduct.SellProductApplicationTests;
import com.sell.sellproduct.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administratoron 2019/3/2
 **/
@Component
public class ProductInfoRepositoryTest extends SellProductApplicationTests {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findAllByProductIdIn() {

        List<ProductInfo> list = productInfoRepository.findAllByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue( list.size() == 2);
    }
}