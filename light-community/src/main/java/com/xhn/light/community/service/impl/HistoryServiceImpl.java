package com.xhn.light.community.service.impl;

import cn.hutool.core.date.DateUtil;
import com.xhn.light.community.entity.vo.HistoryViewList;
import com.xhn.light.community.entity.vo.UserHistoryViewList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.community.dao.HistoryDao;
import com.xhn.light.community.entity.HistoryEntity;
import com.xhn.light.community.service.HistoryService;


@Service("historyService")
public class HistoryServiceImpl extends ServiceImpl<HistoryDao, HistoryEntity> implements HistoryService {

    @Autowired
    private HistoryDao historyDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HistoryEntity> page = this.page(
                new Query<HistoryEntity>().getPage(params),
                new QueryWrapper<HistoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<HistoryViewList>  getUserHistory(String title,Long userId) {
        List<Date>  dayList=historyDao.getAllDay(title,userId);
        List<UserHistoryViewList> result = historyDao.getUserHistory(title,userId);
        List<HistoryViewList> list = new ArrayList<>();
        Long i=1L;
        for (Date s : dayList) {
            HistoryViewList history= new HistoryViewList();
            history.setId(i);
            history.setName(DateUtil.format(s, "yyyy/MM/dd"));
            List<HistoryViewList> listCont = new ArrayList<>();

            for (UserHistoryViewList userHistoryViewList : result) {
                String format = DateUtil.format(userHistoryViewList.getWatchDays(), "yyyy/MM/dd");
                if (format.equals(history.getName())){
                    HistoryViewList historyContent= new HistoryViewList();
                    historyContent.setId(userHistoryViewList.getPageId());
                    historyContent.setData( userHistoryViewList.getWatchTime());
                    historyContent.setName(userHistoryViewList.getTitle());
                    listCont.add(historyContent);
                }
            }
            history.setContent(listCont);
            list.add(history);
            i++;
        }
        

        return list;
    }

}