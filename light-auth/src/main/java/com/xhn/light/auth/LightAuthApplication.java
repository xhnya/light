package com.xhn.light.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * 认证模块
 * 安全模块
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class LightAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightAuthApplication.class, args);
    }

}
