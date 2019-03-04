package com.sell.sellorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// 开启eureka client功能
@EnableEurekaClient
// 开启feign消费服务功能
@EnableFeignClients
public class SellOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellOrderApplication.class, args);
    }

}
