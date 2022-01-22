package com.xhn.light.game;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 游戏服务
 */
@EnableDiscoveryClient
@MapperScan("com.xhn.light.game.dao")
@ComponentScan(basePackages = {"com.xhn"})
@SpringBootApplication
public class LightGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightGameApplication.class, args);
    }

}
