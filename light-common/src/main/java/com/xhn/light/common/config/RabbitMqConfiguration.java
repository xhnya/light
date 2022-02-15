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

    /**
     * 声明交换机
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchangeRegister(){
        return new FanoutExchange("fanout_register_exchange",true,true);
    }

    @Bean
    public Queue registerCountQueue(){
        return new Queue("registerCount.fanout.queue",true);
    }
    @Bean
    public Queue registerLevelQueue(){
        return new Queue("registerLevel.fanout.queue",true);
    }
    @Bean
    public Binding registerCountBinding(){
        return BindingBuilder.bind(registerCountQueue()).to(fanoutExchangeRegister());

    }
    @Bean
    public Binding registerLevelBinding(){
        return BindingBuilder.bind(registerLevelQueue()).to(fanoutExchangeRegister());

    }



}
