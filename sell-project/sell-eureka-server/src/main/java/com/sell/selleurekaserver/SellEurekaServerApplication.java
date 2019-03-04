package com.sell.selleurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SellEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellEurekaServerApplication.class, args);
    }

}
