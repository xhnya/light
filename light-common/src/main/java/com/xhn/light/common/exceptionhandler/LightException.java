package com.xhn.light.common.exceptionhandler;


import com.xhn.light.common.enums.ResultCode;
import lombok.Data;

/**
 * @author xhn
 * @date 2022/1/2 15:40
 * @description: 自定义的异常代码
 */
@Data
public class LightException extends RuntimeException{

    private Integer code;

    private String msg;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    private LightException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    private LightException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public static LightException from(ResultCode resultCode) {
        return new LightException(resultCode.getCode(), resultCode.getMsg());
    }


    public static LightException from(String msg) {
        return new LightException(msg);
    }

    @Override
    public String toString() {
        return "LightException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
