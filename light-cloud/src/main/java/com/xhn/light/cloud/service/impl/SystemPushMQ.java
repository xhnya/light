package com.xhn.light.cloud.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.xhn.light.cloud.service.MailboxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author xhn
 * @date 2022/2/26 1:23
 * @description:
 */
@Component
public class SystemPushMQ {

    private static final Logger logger = LoggerFactory.getLogger(SystemPushMQ.class);

    @Autowired
    private MailboxService mailboxService;

    @RabbitListener(queuesToDeclare = @Queue("system_push"))
    public void emailSend(Map<String, Object> map) {
        String email = (String) map.get("email");
        String message = (String) map.get("message");
        mailboxService.sendPush(email,message);
        logger.info(email+"================>"+message);

    }

}
