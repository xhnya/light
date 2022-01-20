package com.xhn.light.admin.controller;

import com.xhn.light.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description: 提供管理后台登录
 * @author: xhn
 * @date: 2022/1/10 17:39
 */
@Slf4j
@RequestMapping("admin/user")
@RestController
public class AdminUserController {

    @PostMapping("/login")
    public Result loginAdmin(@RequestParam Map<String,Object> params){
        log.info(String.valueOf(params));
        return Result.ok().data("token","admin");
    }
    @GetMapping("/info")
    public Result info(){
        return Result.ok()
                .data("roles","[admin]")
                .data("name","admin")
                .data("avatar","http://img.xhnya.top/img/vae.jpg");
    }


}
