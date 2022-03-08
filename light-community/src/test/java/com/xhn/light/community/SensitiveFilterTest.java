package com.xhn.light.community;

import com.xhn.light.community.utils.SensitiveFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ：xhn
 * @date ：2022/3/8 11:05
 * @description：
 */

@SpringBootTest
public class SensitiveFilterTest {
    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void test01(){
        String text = "这里有人赌博";
        text=sensitiveFilter.filter(text);
        System.out.println(text);
    }

}
