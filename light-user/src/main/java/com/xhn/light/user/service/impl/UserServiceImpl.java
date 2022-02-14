package com.xhn.light.user.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.xhn.light.common.enums.ResultCode;
import com.xhn.light.common.exceptionhandler.LightException;
import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.pojo.UserAnPageView;
import com.xhn.light.common.utils.*;
import com.xhn.light.user.dao.UserInfoDao;
import com.xhn.light.user.entity.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xhn.light.user.dao.UserDao;
import com.xhn.light.user.entity.UserEntity;
import com.xhn.light.user.service.UserService;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserInfoDao userInfoDao;

    private static final String AVATAR="http://img.xhnya.top/img/vae.jpg";

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<PageOfGameName> getUserFromAdminCommunity(List<Long> ids) {
        return userDao.getUserFromAdminCommunity(ids);
    }

    @Override
    public List<UserAnPageView> getCommunityIndex(List<Long> ids) {
        return userDao.getCommunityIndex(ids);
    }

    /**
     * 用户登录逻辑
     * 如果没有这个账号，并且是通过手机号的，则注册账号
     * @param username
     * @param password
     * @return
     */
    @Transactional
    @Override
    public Result getUserAndPassword(String username, String password) {
        PhoneOrEmailOrUserName type = new PhoneOrEmailOrUserName();
        Integer judge = type.judge(username);
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();

        if (judge==1){
            //如果为手机号
            wrapper.eq("phonenumber",username);
        }else if (judge==2){
            //如果为邮箱
            wrapper.eq("email",username);
        }else if (judge==3){
            //如果为用户名
            wrapper.eq("user_name",username);
        }
        UserEntity user = baseMapper.selectOne(wrapper);
        //查出来为空，
        if (user==null){
            //并且是手机号登录
            if (judge==1){
                UserEntity userEntity = new UserEntity();
                userEntity.setCode(IdUtil.simpleUUID());
                userEntity.setPhonenumber(username);
                userEntity.setAvatar(AVATAR);
                userEntity.setUserType("01");
                String userNameSet="用户"+username;
                userEntity.setUserName(userNameSet);
                int i1 = baseMapper.insert(userEntity);
                if (i1<1){
                    throw LightException.from(ResultCode.REGISTER_ERROR);
                }
                //设置用户信息
                UserInfoEntity userInfo = new UserInfoEntity();
                userInfo.setUserId(userEntity.getId());
                userInfo.setUserMobile(username);
                userInfo.setUserName(userNameSet);
                int i = userInfoDao.insert(userInfo);
                if (i<1){
                    throw LightException.from(ResultCode.REGISTER_ERROR);
                }


            }
            throw LightException.from(ResultCode.LOGIN_ERROR);
        }
        String userPassword = user.getPassword();

        if (!SecureUtil.md5(password).equals(userPassword)){
            throw LightException.from(ResultCode.LOGIN_ERROR);
        }
        if (user.getYesapiRySysUserStatus().equals("0")){
            throw LightException.from(ResultCode.LOGIN_ERROR);
        }
        String token = JwtUtils.getJwtToken(user.getId(), user.getCode());

        return Result.ok().data("token",token);
    }

}