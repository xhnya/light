package com.xhn.light.community.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.xhn.light.community.entity.vo.CommunityListViewForIndex;
import com.xhn.light.community.entity.vo.SelectCommunityView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.community.entity.CommunityEntity;
import com.xhn.light.community.service.CommunityService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;


/**
 * 社区表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-17 09:06:04
 */
@RestController
@RequestMapping("community/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("community:community:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = communityService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("community:community:info")
    public Result info(@PathVariable("id") Long id) {
        CommunityEntity community = communityService.getById(id);

        return Result.ok().data("community", community);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("community:community:save")
    public Result save(@RequestBody CommunityEntity community) {
        communityService.save(community);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("community:community:update")
    public Result update(@RequestBody CommunityEntity community) {
        communityService.updateById(community);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("community:community:delete")
    public Result delete(@RequestBody Long[] ids) {
        communityService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

    /**
     * 提供远程调用接口，在创建游戏的时候创建对应的社区
     */
    @PostMapping("/saveFromGame")
    public Result saveFromGame(@RequestBody Map<String, Object> params) {
        CommunityEntity communityEntity = new CommunityEntity();
        //TODO: 捕获类型转换异常
        Long id = Long.valueOf(params.get("id").toString());
        communityEntity.setName((String) params.get("name"));
        communityEntity.setParentId(id);
        communityEntity.setType(0);
        communityService.save(communityEntity);
        return Result.ok();
    }

    @GetMapping("/getCommunityCascader")
    public Result getCommunityCascader() {
        List<SelectCommunityView> result = communityService.getCommunityCascader();
        return Result.ok().data("result", result);
    }

    /**
     * 社区界面的左边的分类显示
     * @return
     */
    @GetMapping("/getCommunityListView")
    public Result getCommunityListView() {
        List<CommunityListViewForIndex> result = communityService.getCommunityListView();
        return Result.ok().data("result", result);
    }


}
