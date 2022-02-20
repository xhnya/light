package com.xhn.light.community.dao;

import com.xhn.light.community.entity.HistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.light.community.entity.vo.UserHistoryViewList;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * 用户历史表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-20 11:54:21
 */
@Mapper
public interface HistoryDao extends BaseMapper<HistoryEntity> {

    List<UserHistoryViewList> getUserHistory(String title,Long userId);

    List<Date> getAllDay(String title,Long userId);
}
