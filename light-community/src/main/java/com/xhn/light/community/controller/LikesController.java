package com.xhn.light.community.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xhn.light.common.utils.JwtUtils;
import com.xhn.light.community.entity.ArticleEntity;
import com.xhn.light.community.service.ArticleService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.community.entity.LikesEntity;
import com.xhn.light.community.service.LikesService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * 文章点赞表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@RestController
@RequestMapping("community/likes")
public class LikesController {
    @Autowired
    private LikesService likesService;
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private ArticleService articleService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("community:likes:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = likesService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("community:likes:info")
    public Result info(@PathVariable("id") Long id){
		LikesEntity likes = likesService.getById(id);

        return Result.ok().data("likes", likes);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("community:likes:save")
    public Result save(@RequestBody LikesEntity likes, HttpServletRequest request){
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")) {
            return Result.error().message("没有登录");
        }
        Long userId = Long.parseLong(info);
        likes.setUid(userId);
        QueryWrapper<LikesEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",userId).eq("pid",likes.getPid());
        long count = likesService.count(wrapper);
        if (count!=0){
            return Result.error().message("你已经点赞过了");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("id",likes.getPid());
        map.put("userId",userId);
        //设置文章的名称
        ArticleEntity article = articleService.getById(likes.getPid());
        map.put("pageName",article.getTitle());
        map.put("toUser",article.getUser());
        rabbitTemplate.convertAndSend("user_likes","",map);
		likesService.save(likes);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("community:likes:update")
    public Result update(@RequestBody LikesEntity likes){
		likesService.updateById(likes);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("community:likes:delete")
    public Result delete(@RequestBody Long[] ids){
		likesService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
