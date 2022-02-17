package com.xhn.light.auth.service;

import com.xhn.light.auth.vo.LoginInfoVo;
import com.xhn.light.common.pojo.UserLogin;
import com.xhn.light.common.utils.Result;

/**
 * @author ：xhn
 * @date ：2022/2/14 15:12
 * @description：
 */
public interface LoginService {
    Result login(UserLogin userLogin);

    String verificationLogin(UserLogin userLogin);
}
