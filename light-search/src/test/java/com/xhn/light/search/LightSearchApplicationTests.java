package com.xhn.light.search;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class LightSearchApplicationTests {

    @Autowired
    private ElasticsearchClient client;

    @Test
    void contextLoads() {
        System.out.println(client);
        System.out.println("111");
    }

}
