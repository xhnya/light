package com.xhn.light.community.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xhn.light.common.utils.JwtUtils;
import com.xhn.light.community.entity.vo.HistoryViewList;
import com.xhn.light.community.entity.vo.UserHistoryViewList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.community.entity.HistoryEntity;
import com.xhn.light.community.service.HistoryService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * 用户历史表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-20 11:54:21
 */
@RestController
@RequestMapping("community/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("community:history:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = historyService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("community:history:info")
    public Result info(@PathVariable("id") Long id) {
        HistoryEntity history = historyService.getById(id);

        return Result.ok().data("history", history);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("community:history:save")
    public Result save(@RequestBody HistoryEntity history) {
        historyService.save(history);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("community:history:update")
    public Result update(@RequestBody HistoryEntity history) {
        historyService.updateById(history);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("community:history:delete")
    public Result delete(@RequestBody Long[] ids) {
        historyService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }


    @PostMapping("/deleteHistory")
    //@RequiresPermissions("community:history:delete")
    public Result deleteHistory(@RequestBody  Long[] ids,HttpServletRequest request) {
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")) {
            return Result.error().message("没有登录");
        }
        Long userId = Long.parseLong(info);
        QueryWrapper<HistoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("pid",ids[0]);
        wrapper.eq("user_id",userId);
        historyService.remove(wrapper);
        return Result.ok();
    }


    @PostMapping("/deleteHistoryAll")
    //@RequiresPermissions("community:history:delete")
    public Result deleteHistoryAll(HttpServletRequest request){
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")) {
            return Result.error().message("没有登录");
        }
        Long userId = Long.parseLong(info);
        QueryWrapper<HistoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        historyService.remove(wrapper);
        return Result.ok();
    }

    @GetMapping("/getUserHistoryList")
    public Result getUserHistory(@RequestParam String title,HttpServletRequest request) {
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")) {
            return Result.error().message("没有登录");
        }
        Long userId = Long.parseLong(info);
        List<HistoryViewList> result = historyService.getUserHistory(title,userId);

        return Result.ok().data("result", result);
    }

}
