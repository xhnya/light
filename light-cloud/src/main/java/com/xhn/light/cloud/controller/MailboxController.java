package com.xhn.light.cloud.controller;

import cn.hutool.core.util.RandomUtil;
import com.xhn.light.cloud.service.MailboxService;
import com.xhn.light.common.utils.Result;
import com.xhn.light.common.utils.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author ：xhn
 * @date ：2022/2/15 15:40
 * @description： 邮箱发送接口
 */
@RestController
@RequestMapping("/cloud/email")
public class MailboxController {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @GetMapping("/sendMailBox/{email}")
    public Result sendMailBox(@PathVariable String email) {
        rabbitTemplate.convertAndSend("email",email);
        return Result.ok();

    }
}
