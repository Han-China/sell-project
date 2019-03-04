package com.sell.order.service;

import com.sell.order.OrderServerApplicationTests;
import com.sell.product.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administratoron 2019/3/2
 **/
@Component
// 日志
@Slf4j
public class FeignRequestTest extends OrderServerApplicationTests {

    // 这个地方报错不用管，因为ProductServer是运行时注入的，idea检测不到
    @Autowired
    private ProductClient productClient;

    @Test
    public void testProductMsg() {

        String result = productClient.getMsg();
        log.info("result = {}", result);
    }
}
