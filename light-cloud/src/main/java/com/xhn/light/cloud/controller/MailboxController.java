package com.xhn.light.cloud.controller;

import cn.hutool.core.util.RandomUtil;
import com.xhn.light.cloud.service.MailboxService;
import com.xhn.light.common.utils.Result;
import com.xhn.light.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private MailboxService mailboxService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/sendMailBox")
    public Result sendMailBox(String email) {
        String code = redisTemplate.opsForValue().get(email);
        if (!StringUtils.isEmpty(code)) {
            return Result.ok();
        }
        code = RandomUtil.randomString(6);
        boolean isSend = mailboxService.sendMailBox(code, email);
        if (isSend) {
            redisTemplate.opsForValue().set(email, code, 3, TimeUnit.MINUTES);
            return Result.ok().message("success");
        } else {
            return Result.error().message("error");
        }
    }
}
