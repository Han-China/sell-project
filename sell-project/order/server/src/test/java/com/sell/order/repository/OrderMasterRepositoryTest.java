package com.sell.order.repository;

import com.sell.order.OrderServerApplicationTests;
import com.sell.order.entity.OrderMaster;
import com.sell.order.enums.OrderStatusEnum;
import com.sell.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Administratoron 2019/3/2
 **/
@Component
public class OrderMasterRepositoryTest extends OrderServerApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {

        OrderMaster orderMaster = new OrderMaster();
        orderMaster
                .setOrderId("123456")
                .setBuyerAddress("康居园小区")
                .setBuyerName("hanshuguang")
                .setBuyerOpenid("110110")
                .setBuyerPhone("12345678912")
                .setOrderAmount(new BigDecimal(2.5))
                .setOrderStatus(OrderStatusEnum.NEW.getCode())
                .setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster = orderMasterRepository.save(orderMaster);

        Assert.assertNotNull(orderMaster);
    }
}