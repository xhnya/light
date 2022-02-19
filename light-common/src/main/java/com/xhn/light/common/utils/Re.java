package com.xhn.light.common.utils;

/**
 * @author ：xhn
 * @date ：2022/2/14 16:01
 * @description： 正则表达式的枚举
 */
public class Re {
    public static final String phone = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$";
    public static final String email = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

}
