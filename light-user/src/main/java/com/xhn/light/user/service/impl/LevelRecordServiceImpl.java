package com.xhn.light.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.user.dao.LevelRecordDao;
import com.xhn.light.user.entity.LevelRecordEntity;
import com.xhn.light.user.service.LevelRecordService;


@Service("levelRecordService")
public class LevelRecordServiceImpl extends ServiceImpl<LevelRecordDao, LevelRecordEntity> implements LevelRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LevelRecordEntity> page = this.page(
                new Query<LevelRecordEntity>().getPage(params),
                new QueryWrapper<LevelRecordEntity>()
        );

        return new PageUtils(page);
    }

}