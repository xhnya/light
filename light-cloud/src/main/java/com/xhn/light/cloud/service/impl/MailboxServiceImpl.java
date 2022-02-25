package com.xhn.light.cloud.service.impl;


import cn.hutool.core.date.DateUtil;
import com.xhn.light.cloud.service.MailboxService;
import com.xhn.light.common.exceptionhandler.LightException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author ：xhn
 * @date ：2022/2/15 15:49
 * @description：
 */
@Slf4j
@Service
public class MailboxServiceImpl implements MailboxService {

    @Value("${spring.mail.username}")
    private String sender;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void sendMailBox(String code, String email) {
        String username = "xhn";
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender, "light");
            helper.setTo(email);
            helper.setSubject("light");
            // 定义模板数据
            Context context = new Context();
            HashMap<String, Object> paramMap = new HashMap<>(16);
            log.info(String.valueOf(code));
            paramMap.put("code", code);
//            paramMap.put("username", username);
            context.setVariables(paramMap);
            // 获取thymeleaf模板，填充数据
            String emailContent = templateEngine.process("email/emial", context);
            helper.setText(emailContent, true);
            // 发送填充好的整个html页面
            javaMailSender.send(message);
            redisTemplate.opsForValue().set(email, code, 3, TimeUnit.MINUTES);
        } catch (Exception e) {
            log.error("-------");
            throw  LightException.from("邮件发送失败");
        }
    }

    public void sendPush( String email,String pushMessage){

        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender, "light");
            helper.setTo(email);
            helper.setSubject("light");
            // 定义模板数据
            Context context = new Context();
            HashMap<String, Object> paramMap = new HashMap<>(16);
            paramMap.put("dataNew",DateUtil.now());
            paramMap.put("pushMessage", pushMessage);
            context.setVariables(paramMap);
            // 获取thymeleaf模板，填充数据
            String emailContent = templateEngine.process("email/push", context);
            helper.setText(emailContent, true);
            // 发送填充好的整个html页面
            javaMailSender.send(message);
        } catch (Exception e) {
            log.error("-------");
            throw  LightException.from("邮件发送失败");
        }
    }
}