package com.xhn.light.common.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xhn
 * @date 2022/1/2 15:40
 * @description: 自定义的异常代码
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LightException extends RuntimeException{
    private Integer code; //状态码
    private String msg; //异常信息


    public LightException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
