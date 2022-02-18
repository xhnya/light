package com.xhn.light.community.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.xhn.light.common.pojo.PageParam;
import com.xhn.light.common.utils.JwtUtils;
import com.xhn.light.community.entity.vo.*;
import lombok.extern.slf4j.Slf4j;
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
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("community:article:info")
    public Result info(@PathVariable("id") Long id) {
        ArticleEntity article = articleService.getById(id);

        return Result.ok().data("article", article);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("community:article:save")
    public Result save(@RequestBody ArticleEntity article) {

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

    @RequestMapping("/saveUserArticle")
    //@RequiresPermissions("community:article:save")
    public Result saveUserArticle(@RequestBody ArticleEntity article, HttpServletRequest request) {
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")) {
            return Result.error().message("没有登录");
        }
        Long userId = Long.parseLong(info);
        article.setUser(userId);
        articleService.save(article);
        return Result.ok();
    }


    /**
     *
     * @param param
     * @return
     */
    @GetMapping("/getInformation")
    public Result getInformation(PageParam param) {
        PageUtils result=articleService.getInformation(param);
        return Result.ok().data("page",result);
    }


}
