package com.xhn.light.auth.vo;

import lombok.Data;

/**
 * @author ：xhn
 * @date ：2022/2/14 15:22
 * @description：
 */
@Data
public class LoginInfoVo {
    private String username;
    private String password;
    private Integer type;
}
