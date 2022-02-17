package com.xhn.light.common.pojo;

import lombok.Data;

/**
 * @author ：xhn
 * @date ：2022/2/14 17:02
 * @description：
 */
@Data
public class UserLogin {
    private String username;
    private String password;
    private Long id;
    /**
     * 用户代码
     */
    private String code;
}
