package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.MessageEntity;
import com.xhn.light.user.service.MessageService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 私信
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
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
