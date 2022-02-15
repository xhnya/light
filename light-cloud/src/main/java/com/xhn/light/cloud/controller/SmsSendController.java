package com.xhn.light.cloud.controller;

import cn.hutool.core.util.RandomUtil;
import com.xhn.light.cloud.service.SmsSendService;
import com.xhn.light.common.utils.Result;
import com.xhn.light.common.utils.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ：xhn
 * @date ：2022/2/15 16:13
 * @description： 短信发送接口
 */
@RestController
@RequestMapping("/cloud/sms")
public class SmsSendController {
    @Autowired
    private SmsSendService smsSendService;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @PostMapping("send/{phone}")
    public Result sendMsm(@PathVariable String phone){
        String code = redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(code)){
            return Result.ok().message("success");
        }
        rabbitTemplate.convertAndSend("sms",phone);
        return Result.ok();

    }
}
