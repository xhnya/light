package com.xhn.light.community.consumer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xhn.light.community.entity.CountsEntity;
import com.xhn.light.community.service.CountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xhn
 * @date 2022/2/20 20:18
 * @description:
 */
@Slf4j
@Component
public class UserCollectionMQ {
    @Autowired
    private CountsService countsService;

    @RabbitListener(queuesToDeclare = @Queue("user_collection"))
    public void addUserHistory(Map<String, Long> map){
        log.info("map====>"+map);
        Long id = map.get("id");
        QueryWrapper<CountsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("pid",id).eq("type",1);
        CountsEntity counts = countsService.getOne(wrapper);
        CountsEntity countsEntity = new CountsEntity();
        if (counts==null){
            countsEntity.setPid(id);
            countsEntity.setType(1);
            countsEntity.setNums(1);
            countsService.save(countsEntity);
        }
        Integer nums = counts.getNums();
        counts.setNums(nums++);
        countsService.updateById(counts);
    }
}
