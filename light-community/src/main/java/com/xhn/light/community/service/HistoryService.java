package com.xhn.light.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.community.entity.HistoryEntity;
import com.xhn.light.community.entity.vo.HistoryViewList;
import com.xhn.light.community.entity.vo.UserHistoryViewList;

import java.util.List;
import java.util.Map;

/**
 * 用户历史表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-20 11:54:21
 */
public interface HistoryService extends IService<HistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<HistoryViewList> getUserHistory(String title,Long userId);
}

