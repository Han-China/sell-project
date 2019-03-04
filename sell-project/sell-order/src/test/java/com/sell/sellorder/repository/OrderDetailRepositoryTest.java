package com.sell.sellorder.repository;

import com.sell.sellorder.SellOrderApplicationTests;
import com.sell.sellorder.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Administratoron 2019/3/2
 **/
@Component
public class OrderDetailRepositoryTest extends SellOrderApplicationTests {

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