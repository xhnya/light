package com.xhn.light.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.community.entity.CommunityEntity;
import com.xhn.light.community.entity.vo.SelectCommunityView;

import java.util.List;
import java.util.Map;

/**
 * 社区表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-17 09:06:04
 */
public interface CommunityService extends IService<CommunityEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SelectCommunityView> getCommunityCascader();
}

