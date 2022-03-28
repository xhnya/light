package com.xhn.light.user;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author xhn
 * @date 2022/3/28 20:35
 * @description:
 */
public class TimeDateForHutoolTest {
    @Test
    public void test01(){
        Date newDateForHouse = DateUtil.offsetHour(DateUtil.date(), 1);
        Date newDateForDay =  DateUtil.offsetDay(DateUtil.date(), 1);
        Date newDateForWeek = DateUtil.offsetWeek(DateUtil.date(), 1);
        Date newDateForMouth=  DateUtil.offsetMonth(DateUtil.date(), 1);
        Date newDateForYear= DateUtil.offsetMonth(DateUtil.date(), 1*12);
        System.out.println(newDateForHouse);
        System.out.println(newDateForDay);
        System.out.println(newDateForWeek);
        System.out.println(newDateForMouth);
        System.out.println(newDateForYear);
        //常用偏移，结果：2017-03-04 22:33:23
    }
    @Test
    public void test02(){
        String format = DateUtil.format(new Date(), "yyyyMMddHHmmss");
        long curr = Long.parseLong(format);
        System.out.println(curr);
    }
}
