package com.xhn.light.user.consume;

import com.xhn.light.user.entity.MessageEntity;
import com.xhn.light.user.entity.NotifyEntity;
import com.xhn.light.user.entity.UserEntity;
import com.xhn.light.user.service.MessageService;
import com.xhn.light.user.service.NotifyService;
import com.xhn.light.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ：xhn
 * @date ：2022/2/23 10:00
 * @description：
 */
@Component
@Slf4j
public class UserLikeMQ {

    @Autowired
    private NotifyService notifyService;

    private static final String USER_LIKE="赞了我的文章";

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    /**
     * 把别人点赞的文章消息存入消息表
     * @param map
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name="user_likes",type = "fanout")
    ))
    public void userLikes(Map<String, Object> map){
        NotifyEntity notify = new NotifyEntity();
        notify.setType("likes");
        notify.setReciverId((Long) map.get("toUser"));
        notify.setSenderId((Long) map.get("userId"));
        notifyService.save(notify);

        UserEntity user = userService.getById((Long) map.get("userId"));

        MessageEntity message = new MessageEntity();
        message.setNotifyId(notify.getId());
        message.setReciverId((Long) map.get("toUser"));
        message.setSenderId((Long) map.get("userId"));
        String content=user.getUserName()+USER_LIKE+map.get("pageName");
        message.setContent(content);
        messageService.save(message);

    }
}
