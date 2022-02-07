package com.xhn.light.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@MapperScan("com.xhn.light.community.dao")
@ComponentScan(basePackages = {"com.xhn"})
@SpringBootApplication
public class LightCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightCommunityApplication.class, args);
    }

}
