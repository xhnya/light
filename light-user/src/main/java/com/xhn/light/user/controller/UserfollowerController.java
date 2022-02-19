package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import com.xhn.light.common.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.UserfollowerEntity;
import com.xhn.light.user.service.UserfollowerService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * 用户粉丝
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@RestController
@RequestMapping("user/userfollower")
public class UserfollowerController {
    @Autowired
    private UserfollowerService userfollowerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:userfollower:list")
    public Result list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")){
            return Result.error().message("没有登录");
        }
        Long userId=Long.parseLong(info);
        PageUtils page = userfollowerService.queryPage(params,userId);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:userfollower:info")
    public Result info(@PathVariable("id") Long id){
		UserfollowerEntity userfollower = userfollowerService.getById(id);

        return Result.ok().data("userfollower", userfollower);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:userfollower:save")
    public Result save(@RequestBody UserfollowerEntity userfollower){
		userfollowerService.save(userfollower);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:userfollower:update")
    public Result update(@RequestBody UserfollowerEntity userfollower){
		userfollowerService.updateById(userfollower);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:userfollower:delete")
    public Result delete(@RequestBody Long[] ids){
		userfollowerService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
