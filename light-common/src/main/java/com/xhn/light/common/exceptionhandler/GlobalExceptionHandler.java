package com.xhn.light.common.exceptionhandler;


import com.xhn.light.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xhn
 * @data 2021/1/31 - 9:38
// */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return  Result.error().message("执行了全局异常处理");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result errorArithmeticException(ArithmeticException e){
        e.printStackTrace();
        return  Result.error().message("执行了ArithmeticException异常处理");
    }

    @ExceptionHandler(LightException.class)
    @ResponseBody
    public Result lightException(LightException e){
       log.error(e.getMessage());
       e.printStackTrace();
        return  Result.error().message(e.getMsg()).code(e.getCode());
   }
}
