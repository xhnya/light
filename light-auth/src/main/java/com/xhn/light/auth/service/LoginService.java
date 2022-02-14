package com.xhn.light.auth.service;

import com.xhn.light.auth.vo.LoginInfoVo;
import com.xhn.light.common.pojo.UserLogin;

/**
 * @author ：xhn
 * @date ：2022/2/14 15:12
 * @description：
 */
public interface LoginService {
    String login(UserLogin userLogin);
}
