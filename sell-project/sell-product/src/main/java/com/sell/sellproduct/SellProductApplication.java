package com.sell.sellproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SellProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellProductApplication.class, args);
    }

}
