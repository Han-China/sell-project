package com.sell.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administratoron 2019/3/2
 **/
@Configuration
public class RestTemplateConfig {

    @Bean
    // 通过@LoadBalanced可以实现LoadBalancerClient的功能，通过服务的应用名从注册中心获取服务的URL，并且实现了负载均衡
    @LoadBalanced
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
