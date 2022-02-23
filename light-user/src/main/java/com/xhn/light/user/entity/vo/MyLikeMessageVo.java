package com.xhn.light.user.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author ：xhn
 * @date ：2022/2/23 14:41
 * @description：
 */
@Data
public class MyLikeMessageVo {

    private Long id;
    private String cover;
    private Date likeTime;
    private String message;
}
