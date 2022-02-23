package com.xhn.light.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.user.entity.MessageEntity;
import com.xhn.light.user.entity.vo.MyLikeMessageVo;

import java.util.List;
import java.util.Map;

/**
 * 私信信息表,包含了所有用户的私信信息
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-23 10:23:42
 */
public interface MessageService extends IService<MessageEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<MyLikeMessageVo> getMyLikeList(Long userId);
}

