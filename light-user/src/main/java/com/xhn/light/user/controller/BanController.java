package com.xhn.light.user.controller;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.xhn.light.common.utils.Result;
import com.xhn.light.user.entity.vo.BanVo;
import com.xhn.light.user.service.BanService;
import com.xhn.light.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @author xhn
 * @date 2022/3/28 17:02
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("user/ban")
public class BanController {

    @Autowired
    private BanService banService;


    /**
     * 解除封禁
     *
     * @return
     */
    @PostMapping("/relieve")
    public Result relieve(@RequestBody Map<String,Long> map) {
        log.info(String.valueOf(map));
        int i = banService.relieve(map.get("id"));
        return i == 1 ? Result.ok("解除成功") : Result.error("解除失败");
    }

    @PostMapping("/ban")
    public Result ban(@RequestBody BanVo ban) {
        int i=banService.ban(ban);
        return  i == 1 ? Result.ok("封禁成功") : Result.error("封禁失败");
    }


}
