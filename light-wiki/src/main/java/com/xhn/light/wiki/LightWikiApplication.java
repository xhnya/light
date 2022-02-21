package com.xhn.light.wiki;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableDiscoveryClient
@MapperScan("com.xhn.light.wiki.dao")
@ComponentScan(basePackages = {"com.xhn"})
@SpringBootApplication
public class LightWikiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightWikiApplication.class, args);
    }

}
