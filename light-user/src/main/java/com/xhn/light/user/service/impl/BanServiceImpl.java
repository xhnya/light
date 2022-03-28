package com.xhn.light.user.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.user.dao.UserDao;
import com.xhn.light.user.entity.BanEntity;
import com.xhn.light.user.entity.UserEntity;
import com.xhn.light.user.entity.vo.BanVo;
import com.xhn.light.user.service.BanService;
import com.xhn.light.user.dao.BanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author xhn
 * @description 针对表【ums_ban(封禁用户表)】的数据库操作Service实现
 * @createDate 2022-03-28 16:59:25
 */
@Service
public class BanServiceImpl extends ServiceImpl<BanDao, BanEntity>
        implements BanService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BanDao banDao;

    @Transactional
    @Override
    public int relieve(Long id) {
        QueryWrapper<BanEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", id);
        int delete = baseMapper.delete(wrapper);
        int user = userDao.updateRelieveBan(id,0);
        return delete == 1 && user == 1 ? 1 : 0;
    }

    @Transactional
    @Override
    public int ban(BanVo ban) {
        BanEntity banEntity = new BanEntity();
        Date date = calculationDate(ban.getNums(), ban.getType());
        banEntity.setUserId(ban.getUserId());
        banEntity.setOverTime(date);
        int insert = baseMapper.insert(banEntity);
        int user = userDao.updateRelieveBan(ban.getUserId(),1);
        return insert == 1 && user == 1 ? 1 : 0;
    }

    private static Date calculationDate(Integer num, String type) {
        if (type.equals("小时")) {
            return DateUtil.offsetHour(DateUtil.date(), num);
        } else if (type.equals("天")) {
            return DateUtil.offsetDay(DateUtil.date(), num);
        } else if (type.equals("星期")) {
            return DateUtil.offsetWeek(DateUtil.date(), num);
        } else if (type.equals("月")) {
            return DateUtil.offsetMonth(DateUtil.date(), num);
        } else {
            return DateUtil.offsetMonth(DateUtil.date(), num * 12);
        }
    }
}




