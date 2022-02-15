package com.xhn.light.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.user.dao.UserLevelDao;
import com.xhn.light.user.entity.UserLevelEntity;
import com.xhn.light.user.service.UserLevelService;


@Slf4j
@Service("userLevelService")
@RabbitListener(queues = "registerLevel.fanout.queue")
public class UserLevelServiceImpl extends ServiceImpl<UserLevelDao, UserLevelEntity> implements UserLevelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserLevelEntity> page = this.page(
                new Query<UserLevelEntity>().getPage(params),
                new QueryWrapper<UserLevelEntity>()
        );
        return new PageUtils(page);
    }

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
        baseMapper.insert(userLevel);
    }



}