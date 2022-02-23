package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.xhn.light.common.utils.JwtUtils;
import com.xhn.light.user.entity.vo.MyLikeMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.user.entity.MessageEntity;
import com.xhn.light.user.service.MessageService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * 私信信息表,包含了所有用户的私信信息
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-23 10:23:42
 */
@RestController
@RequestMapping("user/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:message:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = messageService.queryPage(params);
        return Result.ok().data("page", page);
    }

    @GetMapping("/getMyLikeList")
    public Result getMyLikeList(HttpServletRequest request){
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")){
            return Result.error().message("没有登录");
        }
        Long userId=Long.parseLong(info);
        List<MyLikeMessageVo> result=messageService.getMyLikeList(userId);
        return Result.ok().data("result", result);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:message:info")
    public Result info(@PathVariable("id") Long id){
		MessageEntity message = messageService.getById(id);

        return Result.ok().data("message", message);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:message:save")
    public Result save(@RequestBody MessageEntity message){
		messageService.save(message);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:message:update")
    public Result update(@RequestBody MessageEntity message){
		messageService.updateById(message);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:message:delete")
    public Result delete(@RequestBody Long[] ids){
		messageService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
