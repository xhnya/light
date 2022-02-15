package com.xhn.light.common.utils;

import cn.hutool.core.util.ReUtil;

/**
 * @author ：xhn
 * @date ：2022/2/14 16:01
 * @description： 判断输入的是用户名，邮箱还是手机号
 */
public class PhoneOrEmailOrUserName {

    public static final String PHONECOLUMN= "phonenumber";
    public static final String EMAILCOLUMN= "email";
    public static final String USERNAMECOLUMN= "user_name";


    public String judge(String username) {
        if (ReUtil.isMatch(Re.phone, username)) {
            return PHONECOLUMN;
        }
        if (ReUtil.isMatch(Re.email, username)) {
            return EMAILCOLUMN;
        }
        return USERNAMECOLUMN;
    }
}
