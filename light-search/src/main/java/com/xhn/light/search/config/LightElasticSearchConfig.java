package com.xhn.light.search.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：xhn
 * @date ：2022/2/22 10:58
 * @description： 创建es api
 */
@Configuration
public class LightElasticSearchConfig {

    //    @Bean
//   public ElasticsearchClient esRestClient() {
//
//        RestClientBuilder httpClientBuilder = RestClient.builder(
//                new HttpHost("101.35.8.166", 9201)
//        );
//        RestHighLevelClient hlrc = new RestHighLevelClient(httpClientBuilder);
//        // Create the new Java Client with the same low level client
//        ElasticsearchTransport transport = new RestClientTransport(
//                hlrc.getLowLevelClient(),
//                new JacksonJsonpMapper()
//        );
//       // And create the API client
//        ElasticsearchClient client = new ElasticsearchClient(transport);
//        return client;
//    }
    @Bean
    public RestHighLevelClient esRestClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("101.35.8.166", 9201, "http")));
        return client;
    }

    public static final RequestOptions COMMON_OPTIONS;

    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        // builder.addHeader("Authorization", "Bearer " + TOKEN);
        // builder.setHttpAsyncResponseConsumerFactory(
        //         new HttpAsyncResponseConsumerFactory
        //                 .HeapBufferedResponseConsumerFactory(30 * 1024 * 1024 * 1024));
        COMMON_OPTIONS = builder.build();
    }

}
