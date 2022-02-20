package com.xhn.light.user.consume;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author xhn
 * @date 2022/2/20 11:45
 * @description:
 */
@Component
public class UserHistory {

//    @RabbitListener(queuesToDeclare = @Queue("user_history"))
//    public void addUserHistory(Map<String, Long> map){
//        Long userId = map.get("userId");
//        Long pid = map.get("pid");
//
//    }
}
