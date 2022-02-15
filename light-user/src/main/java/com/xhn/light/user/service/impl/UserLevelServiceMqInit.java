package com.xhn.light.user.service.impl;

import com.xhn.light.user.dao.UserLevelDao;
import com.xhn.light.user.entity.UserLevelEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xhn
 * @date 2022/2/15 20:46
 * @description:
 */
@Slf4j
@Component
@RabbitListener(queues = "registerLevel.fanout.queue")
public class UserLevelServiceMqInit {

    @Autowired
    private UserLevelDao userLevelDao;

    /**
     * 初始化等级
     * @param message
     */
    @RabbitHandler
    public void initUserLevel(Long message){
        log.info("initUserLevel======>"+message);
        UserLevelEntity userLevel = new UserLevelEntity();
        userLevel.setUserId(message);
        userLevel.setLid(1L);
        userLevelDao.insert(userLevel);
    }
}
