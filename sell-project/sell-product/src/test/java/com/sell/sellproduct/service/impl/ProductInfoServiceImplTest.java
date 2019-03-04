package com.sell.sellproduct.service.impl;

import com.sell.sellproduct.SellProductApplicationTests;
import com.sell.sellproduct.dto.CartDTO;
import com.sell.sellproduct.service.ProductInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administratoron 2019/3/2
 **/
@Component
public class ProductInfoServiceImplTest extends SellProductApplicationTests {

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 如果在测试的方法上面加上@Transactional注解，当测试方法执行完成之后会自动进行事务回滚，不会改变数据库中的数据
     */
    @Test
    @Transactional
    public void decreaseStock() {

        List<CartDTO> cartDTOList = new ArrayList();

        CartDTO cartDTO1 = new CartDTO();
        cartDTO1.setProductId("157875196366160022").setProductQuantity(10);
        cartDTOList.add(cartDTO1);

        CartDTO cartDTO2 = new CartDTO();
        cartDTO2.setProductId("157875227953464068").setProductQuantity(15);
        cartDTOList.add(cartDTO2);

        productInfoService.decreaseStock(cartDTOList);
    }
}