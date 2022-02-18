package com.xhn.light.auth;

import cn.hutool.crypto.SecureUtil;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author xhn
 * @date 2022/2/17 19:55
 * @description:
 */
public class md5Test {
    @Test
    public void test01(){
        String md5 = SecureUtil.md5("123456");
        System.out.println(md5);
    }
    @Test
    public void mm(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);
    }
}
