package com.xhn.light.user.service.impl;

import com.xhn.light.user.dao.NotifyDao;
import com.xhn.light.user.entity.vo.MyLikeMessageVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.xhn.light.user.dao.MessageDao;
import com.xhn.light.user.entity.MessageEntity;
import com.xhn.light.user.service.MessageService;


@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageDao, MessageEntity> implements MessageService {

    @Autowired
    private MessageDao messageDao;
    @Autowired
    private NotifyDao notifyDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MessageEntity> page = this.page(
                new Query<MessageEntity>().getPage(params),
                new QueryWrapper<MessageEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<MyLikeMessageVo> getMyLikeList(Long userId) {

        notifyDao.updateLikeRead(userId);
        return messageDao.getMyLikeList(userId);
    }

}