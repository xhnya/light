package com.xhn.light.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 后台整体框架服务，以及后台任务等的处理
 */
@EnableDiscoveryClient
@MapperScan("com.xhn.light.admin.dao")
@ComponentScan(basePackages = {"com.xhn"})
@SpringBootApplication
public class LightAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightAdminApplication.class, args);
    }

}
