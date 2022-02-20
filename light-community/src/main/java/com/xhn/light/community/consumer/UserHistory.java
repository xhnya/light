package com.xhn.light.community.consumer;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xhn.light.community.dao.HistoryDao;
import com.xhn.light.community.entity.HistoryEntity;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author xhn
 * @date 2022/2/20 11:53
 * @description:
 */
@Component
public class UserHistory {

    @Autowired
    private HistoryDao historyDao;

    /**
     * 历史记录
     *
     * @param map
     */
    @RabbitListener(queuesToDeclare = @Queue("user_history"))
    public void addUserHistory(Map<String, Long> map){
        HistoryEntity history = new HistoryEntity();
        Long userId = map.get("userId");
        Long pid = map.get("pid");
        QueryWrapper<HistoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        wrapper.eq("pid",pid);
        Long count = historyDao.selectCount(wrapper);
        if (count==1){
            history.setUpdateTime(new Date());
            historyDao.update(history,wrapper);
        }
        history.setUserId(userId);
        history.setPid(pid);
        history.setWatchDays(DateUtil.date());
        historyDao.insert(history);
    }
}
