package com.xhn.light.common.config;





import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：xhn
 * @date ：2022/2/15 11:52
 * @description： rabbit的配置类
 */
@Configuration
public class RabbitMqConfiguration {

    public static final String PAGE_ADD_EXCHANGE = "page_add_exchange";
    public static final String PAGE_ADD_ES_QUEUE = "page.add.es.queue";
    public static final String PAGE_ADD_COUNT_QUEUE = "page.add.count.queue";
    public static final String WIKI_ADD_EXCHANGE = "wiki_add_exchange";
    public static final String WIKI_ADD_ES_QUEUE = "wiki.add.es.queue";
    public static final String WIKI_ADD_COUNT_QUEUE = "wiki.add.count.queue";

    /*******声明交换机********/
    @Bean
    public FanoutExchange fanoutExchangeRegister(){
        return new FanoutExchange("fanout_register_exchange",true,true);
    }
    @Bean
    public FanoutExchange fanoutExchangePage(){
        return new FanoutExchange(PAGE_ADD_EXCHANGE,true,true);
    }
    @Bean
    public FanoutExchange fanoutExchangeWIKI(){
        return new FanoutExchange(WIKI_ADD_EXCHANGE,true,true);
    }



    /*******声明队列********/
    @Bean
    public Queue registerCountQueue(){
        return new Queue("registerCount.fanout.queue",true);
    }
    @Bean
    public Queue registerLevelQueue(){
        return new Queue("registerLevel.fanout.queue",true);
    }

    @Bean
    public Queue pageEsQueue(){
        return new Queue(PAGE_ADD_ES_QUEUE,true);
    }
    @Bean
    public Queue pageCountQueue(){
        return new Queue(PAGE_ADD_COUNT_QUEUE,true);
    }

    @Bean
    public Queue wikiEsQueue(){
        return new Queue(WIKI_ADD_ES_QUEUE,true);
    }
    @Bean
    public Queue wikiCountQueue(){
        return new Queue(WIKI_ADD_COUNT_QUEUE,true);
    }

    /*******队列交换机绑定********/
    @Bean
    public Binding registerCountBinding(){
        return BindingBuilder.bind(registerCountQueue()).to(fanoutExchangeRegister());

    }
    @Bean
    public Binding registerLevelBinding(){
        return BindingBuilder.bind(registerLevelQueue()).to(fanoutExchangeRegister());

    }

    @Bean
    public Binding pageCountBinding(){
        return BindingBuilder.bind(pageCountQueue()).to(fanoutExchangePage());

    }
    @Bean
    public Binding pageEsBinding(){
        return BindingBuilder.bind(pageEsQueue()).to(fanoutExchangePage());

    }

    @Bean
    public Binding wikiCountBinding(){
        return BindingBuilder.bind(wikiCountQueue()).to(fanoutExchangeWIKI());

    }
    @Bean
    public Binding wikiEsBinding(){
        return BindingBuilder.bind(wikiEsQueue()).to(fanoutExchangeWIKI());

    }



}
