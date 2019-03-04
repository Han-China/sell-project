package com.sell.sellorder.repository;

import com.sell.sellorder.SellOrderApplicationTests;
import com.sell.sellorder.entity.OrderMaster;
import com.sell.sellorder.enums.OrderStatusEnum;
import com.sell.sellorder.enums.PayStatusEnum;
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
public class OrderMasterRepositoryTest extends SellOrderApplicationTests {

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