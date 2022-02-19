package com.xhn.light.user.entity.vo;

import lombok.Data;

/**
 * @author xhn
 * @date 2022/2/19 19:50
 * @description: 我的页面显示
 */
@Data
public class UserInfoForMy {

    private Long id;
    private String cover;
    private String autograph;
    private String phone;
    private String address;
    private String email;
    private String userName;
    private Integer followNums;
    private Integer fansNums;
    private Integer likeNums;
    private Integer gameNums;
    private String bgUrl;
}
