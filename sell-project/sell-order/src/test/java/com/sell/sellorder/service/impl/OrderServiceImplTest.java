package com.sell.sellorder.service.impl;

import com.sell.sellorder.SellOrderApplicationTests;
import com.sell.sellorder.dto.OrderDTO;
import com.sell.sellorder.entity.OrderDetail;
import com.sell.sellorder.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administratoron 2019/3/2
 **/
@Component
public class OrderServiceImplTest extends SellOrderApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("157875196366160022").setProductQuantity(5);
        orderDetailList.add(orderDetail1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("157875227953464068").setProductQuantity(10);
        orderDetailList.add(orderDetail2);

        OrderDTO orderDTO = new OrderDTO();
        orderDTO
                .setBuyerAddress("武汉市洪山区康居园小区10栋2单元803室")
                .setBuyerName("hanshuguang")
                .setBuyerOpenid("111111")
                .setBuyerPhone("1234567891213")
                .setOrderDetailList(orderDetailList);

        orderDTO = orderService.create(orderDTO);

        Assert.assertNotNull(orderDTO);
    }
}