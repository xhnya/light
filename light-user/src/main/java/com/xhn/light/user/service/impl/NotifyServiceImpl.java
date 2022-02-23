package com.xhn.light.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.xhn.light.user.dao.NotifyDao;
import com.xhn.light.user.entity.NotifyEntity;
import com.xhn.light.user.service.NotifyService;


@Service("notifyService")
public class NotifyServiceImpl extends ServiceImpl<NotifyDao, NotifyEntity> implements NotifyService {

    @Autowired
    private NotifyDao notifyDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NotifyEntity> page = this.page(
                new Query<NotifyEntity>().getPage(params),
                new QueryWrapper<NotifyEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Long getNoReadNums(Long userId) {
        QueryWrapper<NotifyEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("reciver_id",userId).eq("is_read",0);

        return notifyDao.selectCount(wrapper);
    }

}