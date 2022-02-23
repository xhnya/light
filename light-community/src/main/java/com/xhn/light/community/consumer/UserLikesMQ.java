package com.xhn.light.community.consumer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xhn.light.community.entity.CountsEntity;
import com.xhn.light.community.service.CountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xhn
 * @date 2022/2/20 20:37
 * @description:
 */
@Slf4j
@Component
public class UserLikesMQ {
    @Autowired
    private CountsService countsService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name="user_likes",type = "fanout")
    ))
    public void userLikes(Map<String, Object> map){
        log.info("map====>"+map);
        Long id = (Long) map.get("id");
        QueryWrapper<CountsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("pid",id).eq("type",0);
        CountsEntity counts = countsService.getOne(wrapper);
        CountsEntity countsEntity = new CountsEntity();
        if (counts==null){
            countsEntity.setPid(id);
            countsEntity.setType(0);
            countsEntity.setNums(1);
            countsService.save(countsEntity);
        }else {
            Integer nums = counts.getNums();
            nums++;
            counts.setNums(nums);

            countsService.updateById(counts);
        }

    }
}
