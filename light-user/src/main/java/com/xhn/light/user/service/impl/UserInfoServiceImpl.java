package com.xhn.light.user.service.impl;

import com.xhn.light.user.dao.UserDao;
import com.xhn.light.user.entity.UserEntity;
import com.xhn.light.user.entity.vo.UserInfoForMy;
import com.xhn.light.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.user.dao.UserInfoDao;
import com.xhn.light.user.entity.UserInfoEntity;
import com.xhn.light.user.service.UserInfoService;
import org.springframework.transaction.annotation.Transactional;


@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserDao userDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserInfoEntity> page = this.page(
                new Query<UserInfoEntity>().getPage(params),
                new QueryWrapper<UserInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public UserInfoForMy getUserInfo(Long userId) {
        UserInfoForMy result= userInfoDao.getUserInfo(userId);

        return result;
    }


    @Override
    public void updateUserInfo(UserInfoEntity userInfo,Long userID) {
        UserEntity user = new UserEntity();
        user.setAvatar(userInfo.getAvatar());
        user.setUserId(userInfo.getId());
        user.setUserName(userInfo.getUserName());
        user.setId(userID);
        QueryWrapper<UserInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userID);
        userInfoDao.update(userInfo,wrapper);
        userDao.updateById(user);
    }

}