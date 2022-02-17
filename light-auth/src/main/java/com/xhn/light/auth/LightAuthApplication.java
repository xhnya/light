package com.xhn.light.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 云服务
 * 主要提供
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class LightAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightAuthApplication.class, args);
    }

}
