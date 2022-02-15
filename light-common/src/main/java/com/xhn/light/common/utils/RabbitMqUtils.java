package com.xhn.light.common.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author ：xhn
 * @date ：2022/2/15 11:40
 * @description：
 */
public class RabbitMqUtils {
    //得到一个连接的 channel
    public static Channel getChannel() throws Exception{
        //创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("101.35.8.166");
        factory.setUsername("xhnya");
        factory.setPassword("xhnya@1216");
        factory.setPort(5673);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        return channel;
    }
}
