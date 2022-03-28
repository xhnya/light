package com.xhn.light.user.dask;

import cn.hutool.core.date.DateUtil;
import com.xhn.light.user.dao.BanDao;
import com.xhn.light.user.dao.UserDao;
import com.xhn.light.user.entity.BanEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xhn
 * @date 2022/3/28 21:51
 * @description: 解除用户封禁的定时任务
 * TODO: 定时任务统一管理，并且添加到数据库
 */
@Configuration
@EnableScheduling
public class RelieveDask {

    private static final Logger logger = LoggerFactory.getLogger(RelieveDask.class);

    @Autowired
    private BanDao banDao;

    @Autowired
    private UserDao userDao;

    //添加定时任务 0 0 1 * * ? 表示每天凌晨一点执行
    @Scheduled(cron = "0 0 1 * * ?")
    public void configureTasks() {
        List<BanEntity> list = banDao.selectList(null);
        String format = DateUtil.format(new Date(), "yyyyMMddHHmmss");
        long curr = Long.parseLong(format);
        ArrayList<Long> ban = new ArrayList<>();
        ArrayList<Long> user = new ArrayList<>();
        for (BanEntity banEntity : list) {
            String overTime= DateUtil.format(banEntity.getOverTime(), "yyyyMMddHHmmss");
            long over = Long.parseLong(overTime);
            if (over<curr){
                ban.add(banEntity.getId());
                user.add(banEntity.getUserId());
            }
        }
        logger.info("RelieveDask====>ban====>"+String.valueOf(ban));
        logger.info("RelieveDask====>user====>"+String.valueOf(user));
        banDao.deleteBatchIds(ban);
        userDao.updateRelieveUser(user);
    }
}
