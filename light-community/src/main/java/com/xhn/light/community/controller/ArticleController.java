package com.xhn.light.community.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.core.lang.hash.Hash;
import com.xhn.light.common.config.RabbitMqConfiguration;
import com.xhn.light.common.pojo.PageParam;
import com.xhn.light.common.utils.JwtUtils;
import com.xhn.light.community.entity.vo.*;
import com.xhn.light.community.utils.SensitiveFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.community.entity.ArticleEntity;
import com.xhn.light.community.service.ArticleService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * 社区文章表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@Slf4j
@RestController
@RequestMapping("community/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private SensitiveFilter sensitiveFilter;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("community:article:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = articleService.queryPage(params);

        return Result.ok().data("page", page);
    }

    /**
     * 页面的列表，管理后台
     */
    @GetMapping("/pageAdminList")
    //@RequiresPermissions("community:article:list")
    public Result pageAdminList(ArticleAdminListQueryVo params) {
        PageUtils page = articleService.selectPageAdminList(params);
        return Result.ok().data("page", page);
    }


    /**
     * 获取页面的详情
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("community:article:info")
    public Result info(@PathVariable("id") Long id, HttpServletRequest request) {
        String info = JwtUtils.getUserInfoByJwtToken(request);
        //如果用户登录了，那么就报错历史记录
        if (!info.equals("")) {
            Long userId = Long.parseLong(info);
            Map<String, Long> map = new HashMap<>();
            map.put("userId", userId);
            map.put("pid", id);
            rabbitTemplate.convertAndSend("user_history", map);
        }
        ArticleEntity article = articleService.getById(id);

        return Result.ok().data("article", article);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("community:article:save")
    public Result save(@RequestBody ArticleEntity article) {
        String content = article.getContent();
        String filter = sensitiveFilter.filter(content);
        article.setContent(filter);
        //添加到es，加上统计表
        articleService.save(article);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("community:article:update")
    public Result update(@RequestBody ArticleEntity article) {
        articleService.updateById(article);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("community:article:delete")
    public Result delete(@RequestBody Long[] ids) {
        articleService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

    /**
     * 社区主界面的列表显示
     *
     * @param params
     * @return
     */
    @GetMapping("indexListView")
    public Result CommunityIndexListView(CommunityIndexListParam params) {
        PageUtils result = articleService.selectCommunityIndexView(params);
        return Result.ok().data("results", result);
    }


    /**
     * 首页游戏动态展示
     *
     * @return
     */
    @GetMapping("getGamePageInfoLit")
    public Result getGamePageInfoLit() {
        List<IndexHotPageList> result = articleService.getGamePageInfoLit();
        return Result.ok().data("result", result);
    }


    /**
     * 本站需知
     *
     * @return
     */
    @GetMapping("getUserNeedKnow")
    public Result getUserNeedKnow() {
        List<IndexHotPageList> result = articleService.getUserNeedKnow();
        return Result.ok().data("list", result);
    }

    /**
     * 用户文章
     *
     * @param article
     * @param request
     * @return
     */
    @RequestMapping("/saveUserArticle")
    //@RequiresPermissions("community:article:save")
    public Result saveUserArticle(@RequestBody ArticleEntity article, HttpServletRequest request) {
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")) {
            return Result.error().message("没有登录");
        }
        Long userId = Long.parseLong(info);
        article.setUser(userId);
        //敏感词过滤
        String content = article.getContent();
        String filter = sensitiveFilter.filter(content);
        article.setContent(filter);

        articleService.save(article);

        Map<String,Object> map=new HashMap<>();
        map.put("id",article.getId());
        map.put("name",article.getTitle());
        rabbitTemplate.convertAndSend(RabbitMqConfiguration.PAGE_ADD_EXCHANGE,"",map);

        return Result.ok();
    }


    /**
     * 获取资讯列表
     *
     * @param params
     * @return
     */
    @GetMapping("/getInformation")
    public Result getInformation(@RequestParam Map<String, Object> params) {
        PageUtils result = articleService.getInformation(params);
        return Result.ok().data("page", result);
    }

    @GetMapping("/getInformationByGameId")
    public Result getInformationByGameId(InformationByGameIdParam param) {
        PageUtils result = articleService.getInformationByGameId(param);
        return Result.ok().data("page", result);
    }

    /**
     * 下拉框获取评测的文章
     *
     * @return
     */
    @GetMapping("/getSelectPage")
    public Result getSelectPage() {
        List<CommunityListViewForIndex> result = articleService.getSelectPage();
        return Result.ok().data("result", result);
    }

    /**
     * 获取我发表的文章
     *
     * @param param
     * @param request
     * @return
     */
    @GetMapping("/getMyPageList")
    public Result getMyPageList( CommunityIndexListParam param, HttpServletRequest request) {
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")) {
            return Result.error().message("没有登录");
        }
        Long userId = Long.parseLong(info);
        PageUtils page = articleService.getMyPageList(param, userId);
        return Result.ok().data("page", page);
    }
    @GetMapping("/getGameCommunityList")
    public Result getGameCommunityList( GameCommunityParams params) {
        PageUtils result = articleService.getGameCommunityList(params);
        return Result.ok().data("results", result);
    }

    @GetMapping("/gameInfoList")
    public Result gameInfoList( @RequestParam Long id) {
        List<IdAndName> result = articleService.gameInfoList(id);
        return Result.ok().data("results", result);
    }


}
