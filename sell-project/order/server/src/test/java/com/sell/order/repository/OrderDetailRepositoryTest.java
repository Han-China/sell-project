package com.sell.order.repository;

import com.sell.order.OrderServerApplicationTests;
import com.sell.order.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Administratoron 2019/3/2
 **/
@Component
public class OrderDetailRepositoryTest extends OrderServerApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave() {

        OrderDetail orderDetail = new OrderDetail();
        orderDetail
                .setOrderId("123456")
                .setProductIcon("http://xxx.png")
                .setProductId("157875196366160022")
                .setDetailId("119119")
                .setProductName("皮蛋粥")
                .setProductPrice(new BigDecimal(2.5))
                .setProductQuantity(1);

        orderDetail = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(orderDetail);
    }
}