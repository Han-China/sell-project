package com.sell.sellorder.service;

import com.sell.sellorder.SellOrderApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administratoron 2019/3/2
 **/
@Component
// 日志
@Slf4j
public class RibbonRequestTest extends SellOrderApplicationTests {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @Test
    public void testProductMsg() {

        RestTemplate restTemplate = new RestTemplate();

        // 方式一：直接使用restTemplate，URL写死
//        String result = restTemplate.getForObject("http://localhost:8010/server/product/msg", String.class);

        // 方式二：利用loadBalancerClient通过应用名获取URL，再使用restTemplate，loadBalancerClient获取服务的URL时实现了负载均衡
        ServiceInstance serviceInstance = loadBalancerClient.choose("sell-product");
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = String.format("http://%s:%s/%s", host, port, "server/product/msg");
        log.info("url = {}", url);
        String result = restTemplate.getForObject(url, String.class);

        // 方式三：利用@LoadBalanced注解实现了方式二的功能，通过应用名获取服务的URL
//        String result = restTemplate.getForObject("http://sell-product/server/product/msg", String.class);

        log.info("result = {}", result);
    }
}
