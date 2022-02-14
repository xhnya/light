package com.xhn.light.common.utils;

import cn.hutool.core.util.ReUtil;

/**
 * @author ：xhn
 * @date ：2022/2/14 16:01
 * @description： 判断输入的是用户名，邮箱还是手机号
 */
public class PhoneOrEmailOrUserName {

    public Integer judge(String username){
        if (ReUtil.isMatch(Re.phone, username)){
            return 1;
        }
        if (ReUtil.isMatch(Re.email, username)){
            return 2;
        }
        return 3;
    }
}
