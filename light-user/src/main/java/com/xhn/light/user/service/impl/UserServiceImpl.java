package com.xhn.light.user.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.rabbitmq.client.Channel;
import com.xhn.light.common.enums.ResultCode;
import com.xhn.light.common.exceptionhandler.LightException;
import com.xhn.light.common.name.MqName;
import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.pojo.UserAnPageView;
import com.xhn.light.common.pojo.UserLogin;
import com.xhn.light.common.utils.*;
import com.xhn.light.user.dao.UserInfoDao;
import com.xhn.light.user.entity.UserInfoEntity;
import com.xhn.light.user.entity.UserLevelEntity;
import com.xhn.light.common.utils.RabbitMqUtils;
import com.xhn.light.user.entity.vo.UserInfoView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xhn.light.user.dao.UserDao;
import com.xhn.light.user.entity.UserEntity;
import com.xhn.light.user.service.UserService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String AVATAR = "http://img.xhnya.top/img/vae.jpg";

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
     * TODO: 开启分布式事务，主要是和统计表一起
     *
     * @param username
     * @param password
     * @return
     */
    @Transactional
    @Override
    public Result getUserAndPassword(String username, String password) {
        //判断类型
        PhoneOrEmailOrUserName type = new PhoneOrEmailOrUserName();
        String judge = type.judge(username);
        //查询数据库中是否有该字段
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(judge, username);

        Long count = baseMapper.selectCount(wrapper);
        UserEntity user = baseMapper.selectOne(wrapper);


        //手机号登录或者邮箱则从redis中获取验证码
        if (judge.equals(PhoneOrEmailOrUserName.PHONECOLUMN) ||
                judge.equals(PhoneOrEmailOrUserName.EMAILCOLUMN)) {
            //从redis中获取数据查看是否匹配
            String code = redisTemplate.opsForValue().get(username);
            log.info("username" + username + "===========>" + code);
            if (!password.equals(code)) {
                throw LightException.from(ResultCode.LOGIN_CODE_ERROR);
            }
            /**
             * 验证通过，并且查出来的数据为空
             *
             */
            if (count == 0) {
                if (judge.equals(PhoneOrEmailOrUserName.PHONECOLUMN)) {
                    /**
                     * 手机号第一次登录
                     * 则进入注册环节
                     */
                    UserEntity userEntity = new UserEntity();
                    userEntity.setCode(IdUtil.simpleUUID());
                    userEntity.setPhonenumber(username);
                    userEntity.setAvatar(AVATAR);
                    userEntity.setUserType("01");
                    String userNameSet = "用户" + username;
                    userEntity.setUserName(userNameSet);
                    int i1 = baseMapper.insert(userEntity);
                    if (i1 < 1) {
                        throw LightException.from(ResultCode.REGISTER_ERROR);
                    }
                    //设置用户信息
                    UserInfoEntity userInfo = new UserInfoEntity();
                    userInfo.setUserId(userEntity.getId());
                    userInfo.setUserMobile(username);
                    userInfo.setUserName(userNameSet);
                    int i = userInfoDao.insert(userInfo);
                    if (i < 1) {
                        throw LightException.from(ResultCode.REGISTER_ERROR);
                    }
                    /**
                     * 把消息放进mq里面
                     * 添加注册人数
                     * 等级添加
                     */
                    Map<String, Object> map = new HashMap<>();

                    Long entityId = userEntity.getId();
                    map.put("id",entityId);
                    map.put("name",userNameSet);
                    rabbitTemplate.convertAndSend("fanout_register_exchange", "", entityId);
                    rabbitTemplate.convertAndSend("register_es",map);
                    /**
                     * 注册成功则返回token，和登录成功一样
                     */
                    String token = JwtUtils.getJwtToken(userEntity.getId(), userEntity.getCode());
                    return Result.ok().data("token", token);
                } else {
                    throw LightException.from(ResultCode.LOGIN_NOT);
                }
            }
        } else if (!SecureUtil.md5(password).equals(user.getPassword())) {
            //否则通过密码验证
            throw LightException.from(ResultCode.LOGIN_ERROR);
        }
        //判断账号状态
        if (!user.getYesapiRySysUserStatus().equals("0")) {
            throw LightException.from(ResultCode.LOGIN_COUNT_ERROR);
        }
        String token = JwtUtils.getJwtToken(user.getId(), user.getCode());

        return Result.ok().data("token", token);
    }

    @Override
    public UserLogin getUserAndPassword1(String username, String password) {
        PhoneOrEmailOrUserName type = new PhoneOrEmailOrUserName();
        String judge = type.judge(username);
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(judge, username);
        Long count = baseMapper.selectCount(wrapper);
        log.info(username + "========>");
        log.info(password + "========>");
        if (count == 0) {
            throw LightException.from(ResultCode.LOGIN_NOT);
        }
        UserEntity user = baseMapper.selectOne(wrapper);
        //判断账号状态
        if (!user.getYesapiRySysUserStatus().equals("0")) {
            throw LightException.from(ResultCode.LOGIN_COUNT_ERROR);
        }
        UserLogin login = new UserLogin();
        login.setUsername(username);
        login.setPassword(user.getPassword());
        login.setCode(user.getCode());
        login.setId(user.getId());
        log.info("login========>" + String.valueOf(login));
        return login;
    }

    @Override
    public UserInfoView getUserInfoByToken(Long userId) {
        return userDao.getUserInfoByToken(userId);
    }

    @Override
    public UserLogin getUserInfoForAuth(String username, String password) {
        //判断类型
        PhoneOrEmailOrUserName type = new PhoneOrEmailOrUserName();
        String judge = type.judge(username);
        //查询数据库中是否有该字段
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(judge, username);
        UserLogin login = new UserLogin();
        Long count = baseMapper.selectCount(wrapper);
        if (count==0){
            if (judge.equals(PhoneOrEmailOrUserName.PHONECOLUMN)) {
                /**
                 * 手机号第一次登录
                 * 则进入注册环节
                 */
                UserEntity userEntity = new UserEntity();
                userEntity.setCode(IdUtil.simpleUUID());
                userEntity.setPhonenumber(username);
                userEntity.setAvatar(AVATAR);
                userEntity.setUserType("01");
                String userNameSet = "用户" + username;
                userEntity.setUserName(userNameSet);
                int i1 = baseMapper.insert(userEntity);
                if (i1 < 1) {
                    throw LightException.from(ResultCode.REGISTER_ERROR);
                }
                //设置用户信息
                UserInfoEntity userInfo = new UserInfoEntity();
                userInfo.setUserId(userEntity.getId());
                userInfo.setUserMobile(username);
                userInfo.setUserName(userNameSet);
                userInfo.setBgUrl("http://img.xhnya.top/img/userbg.webp");
                int i = userInfoDao.insert(userInfo);
                if (i < 1) {
                    throw LightException.from(ResultCode.REGISTER_ERROR);
                }
                /**
                 * 把消息放进mq里面
                 * 添加注册人数
                 * 等级添加
                 */
                Long entityId = userEntity.getId();
                rabbitTemplate.convertAndSend("fanout_register_exchange", "", entityId);

                login.setId(userEntity.getId());
                login.setCode(userEntity.getCode());
                return login;
            } else {
                throw LightException.from(ResultCode.LOGIN_NOT);
            }
        }
        UserEntity user = baseMapper.selectOne(wrapper);
        //判断账号状态
        if (!user.getYesapiRySysUserStatus().equals("0")) {
            throw LightException.from(ResultCode.LOGIN_COUNT_ERROR);
        }
        login.setId(user.getId());
        login.setCode(user.getCode());
        return login;
    }

}