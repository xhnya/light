package com.xhn.light.admin.controller;

import com.xhn.light.admin.entity.SubscribeEntity;
import com.xhn.light.admin.service.SubscribeService;
import com.xhn.light.common.utils.Result;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author xhn
 * @date 2022/2/26 2:08
 * @description:
 */
@RestController
@RequestMapping("admin/push")
public class PushEmailController {

    @Autowired
    private SubscribeService subscribeService;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @PostMapping("/message")
    public Result pushEmail(@RequestBody String message){
        List<SubscribeEntity> list = subscribeService.list();
        for (SubscribeEntity subscribe : list) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("message",message);
            map.put("email",subscribe.getEmail());
            rabbitTemplate.convertAndSend("system_push",map);
        }
        return Result.ok();

    }
}
