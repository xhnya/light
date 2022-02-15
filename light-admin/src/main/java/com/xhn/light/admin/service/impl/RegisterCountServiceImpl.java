package com.xhn.light.admin.service.impl;

import cn.hutool.core.date.DateUtil;
import com.xhn.light.common.name.MqName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.admin.dao.RegisterCountDao;
import com.xhn.light.admin.entity.RegisterCountEntity;
import com.xhn.light.admin.service.RegisterCountService;

@Slf4j
@Service("registerCountService")
@RabbitListener(queues = "registerCount.fanout.queue")
public class RegisterCountServiceImpl extends ServiceImpl<RegisterCountDao, RegisterCountEntity> implements RegisterCountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RegisterCountEntity> page = this.page(
                new Query<RegisterCountEntity>().getPage(params),
                new QueryWrapper<RegisterCountEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 注册人数统计
     *
     * @param message 传入的应当是userid
     */
    @RabbitHandler
    public void registerCount(Long message){
        RegisterCountEntity count = new RegisterCountEntity();
        log.info("registerCount=====>"+message);
        String data = DateUtil.format(DateUtil.date(), "yyyyMMdd");
        count.setDays(data);
        QueryWrapper<RegisterCountEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("days", data);
        RegisterCountEntity one = baseMapper.selectOne(wrapper);
        if (one==null){
            count.setNums(1);
            baseMapper.insert(count);
        }else {
            count.setNums(one.getNums()+1);
            baseMapper.update(count,wrapper);
        }
    }

}