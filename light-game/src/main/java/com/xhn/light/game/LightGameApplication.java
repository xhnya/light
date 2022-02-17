package com.xhn.light.game;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 游戏服务
 */
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.xhn.light.game.dao")
@ComponentScan(basePackages = {"com.xhn"})
@SpringBootApplication
public class LightGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightGameApplication.class, args);
    }

}
