package com.xhn.light.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.user.dao.HistoryDao;
import com.xhn.light.user.entity.HistoryEntity;
import com.xhn.light.user.service.HistoryService;


@Service("historyService")
public class HistoryServiceImpl extends ServiceImpl<HistoryDao, HistoryEntity> implements HistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HistoryEntity> page = this.page(
                new Query<HistoryEntity>().getPage(params),
                new QueryWrapper<HistoryEntity>()
        );

        return new PageUtils(page);
    }

}