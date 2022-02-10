package com.xhn.light.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.user.dao.TaskTypeDao;
import com.xhn.light.user.entity.TaskTypeEntity;
import com.xhn.light.user.service.TaskTypeService;


@Service("taskTypeService")
public class TaskTypeServiceImpl extends ServiceImpl<TaskTypeDao, TaskTypeEntity> implements TaskTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TaskTypeEntity> page = this.page(
                new Query<TaskTypeEntity>().getPage(params),
                new QueryWrapper<TaskTypeEntity>()
        );

        return new PageUtils(page);
    }

}