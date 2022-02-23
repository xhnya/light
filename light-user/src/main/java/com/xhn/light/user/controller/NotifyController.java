package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import com.xhn.light.common.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.user.entity.NotifyEntity;
import com.xhn.light.user.service.NotifyService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * 用户通知表,包含了所有用户的消息
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-23 09:36:31
 */
@RestController
@RequestMapping("user/notify")
public class NotifyController {
    @Autowired
    private NotifyService notifyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:notify:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = notifyService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:notify:info")
    public Result info(@PathVariable("id") Long id){
		NotifyEntity notify = notifyService.getById(id);

        return Result.ok().data("notify", notify);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:notify:save")
    public Result save(@RequestBody NotifyEntity notify){
		notifyService.save(notify);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:notify:update")
    public Result update(@RequestBody NotifyEntity notify){
		notifyService.updateById(notify);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:notify:delete")
    public Result delete(@RequestBody Long[] ids){
		notifyService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

    @GetMapping("/getNoReadNums")
    public Result getNoReadNums(HttpServletRequest request){
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")){
            return Result.error().message("没有登录");
        }
        Long userId=Long.parseLong(info);
        Long result=notifyService.getNoReadNums(userId);
        return  Result.ok().data("result",result);
    }

}
