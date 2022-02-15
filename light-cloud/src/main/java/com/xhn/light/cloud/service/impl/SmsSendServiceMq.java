package com.xhn.light.cloud.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.xhn.light.cloud.service.SmsSendService;
import com.xhn.light.common.exceptionhandler.LightException;
import com.xhn.light.common.utils.Result;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author xhn
 * @date 2022/2/15 22:04
 * @description: 使用RabbitMQ发送短信
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("sms"))
public class SmsSendServiceMq {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private SmsSendService smsSendService;
    @RabbitHandler
    public void sendSms(String phone){
        Map<String,Object> param=new HashMap<>();
        String code = RandomUtil.randomString(6);
        param.put("code",code);
        Boolean isSend=smsSendService.send(param,phone);
        if (isSend){
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
        }else {
            throw LightException.from("短信验证码发送失败");
        }
    }
}
