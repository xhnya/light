package com.xhn.light.user.service.impl;

import com.xhn.light.common.utils.Result;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.user.dao.LevelDao;
import com.xhn.light.user.entity.LevelEntity;
import com.xhn.light.user.service.LevelService;


@Service("levelService")
public class LevelServiceImpl extends ServiceImpl<LevelDao, LevelEntity> implements LevelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LevelEntity> page = this.page(
                new Query<LevelEntity>().getPage(params),
                new QueryWrapper<LevelEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Result saveLevelEntity(LevelEntity level) {
        QueryWrapper<LevelEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("level_sort",level.getLevelSort());
        Long count = baseMapper.selectCount(wrapper);
        if (count!=0){
            return Result.error().message("已经有该等级");
        }
        baseMapper.insert(level);
        return Result.ok();
    }

}