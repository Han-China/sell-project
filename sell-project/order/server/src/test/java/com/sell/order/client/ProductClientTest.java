package com.sell.order.client;

import com.sell.order.OrderServerApplicationTests;
import com.sell.product.client.ProductClient;
import com.sell.product.common.DecreaseStockInput;
import com.sell.product.common.ProductInfoOutput;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administratoron 2019/3/2
 **/
@Component
public class ProductClientTest extends OrderServerApplicationTests {

    @Autowired
    private ProductClient productClient;

    @Test
    public void testListForOrder() {

        List<ProductInfoOutput> list = productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(list.size() == 2);
    }

    /**
     * 如果在测试的方法上面加上@Transactional注解，当测试方法执行完成之后会自动进行事务回滚，不会改变数据库中的数据
     */
    @Test
    @Transactional
    public void testDecreaseStock() {

        List<DecreaseStockInput> cartDTOList = new ArrayList();

        DecreaseStockInput cartDTO1 = new DecreaseStockInput();
        cartDTO1.setProductId("157875196366160022").setProductQuantity(10);
        cartDTOList.add(cartDTO1);

        DecreaseStockInput cartDTO2 = new DecreaseStockInput();
        cartDTO2.setProductId("157875227953464068").setProductQuantity(15);
        cartDTOList.add(cartDTO2);

        productClient.decreaseStock(cartDTOList);
    }
}