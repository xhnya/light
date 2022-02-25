package com.xhn.light.cloud.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.xhn.light.cloud.service.MailboxService;
import com.xhn.light.common.exceptionhandler.LightException;
import com.xhn.light.common.utils.Result;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author xhn
 * @date 2022/2/15 22:10
 * @description:
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("email"))
public class EmailMQService {

    @Autowired
    private MailboxService mailboxService;

    @Autowired
    private StringRedisTemplate redisTemplate;
    @RabbitHandler
    public void emailSend(String email){
        String code = RandomUtil.randomString(6);
        mailboxService.sendMailBox(code, email);

    }
}
