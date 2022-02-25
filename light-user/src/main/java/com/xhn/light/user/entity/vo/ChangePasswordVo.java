package com.xhn.light.user.entity.vo;

import lombok.Data;

/**
 * @author xhn
 * @date 2022/2/25 21:54
 * @description:
 */
@Data
public class ChangePasswordVo {
    private String userName;
    private String code;
    private String pass;
    private String checkPass;
    private Integer type;

}
