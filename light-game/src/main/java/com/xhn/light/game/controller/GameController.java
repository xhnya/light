package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.game.entity.vo.GameInfoVo;
import com.xhn.light.game.entity.vo.ReleaseOrHotGameList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.game.entity.GameEntity;
import com.xhn.light.game.service.GameService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;


/**
 * 游戏表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
@RestController
@RequestMapping("game/game")
public class GameController {
    @Autowired
    private GameService gameService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:game:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = gameService.queryPage(params);

        return Result.ok().data("page", page);
    }

    /**
     * 获取列表
     */
    @RequestMapping("/gameList")
    //@RequiresPermissions("game:game:list")
    public Result gameList(@RequestParam Map<String, Object> params) {
        PageUtils page = gameService.gameList(params);

        return Result.ok().data("page", page);
    }

    /**
     * 下拉框的游戏列表
     *
     * @return
     */
    @GetMapping("/gameListForSelect")
    public Result gameListForSelect() {
        List<GameEntity> list = gameService.list();
        return Result.ok().data("gameList", list);
    }

    /**
     * 获取游戏的详细信息
     *
     * @param id 传入游戏的id
     * @return
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:game:info")
    public Result info(@PathVariable("id") Long id) {
        GameInfoVo game = gameService.getGameInfo(id);
        return Result.ok().data("game", game);
    }

    /**
     * 页面显示游戏详情
     *
     * @param id
     * @return
     */
    @GetMapping("/gameInfo/{id}")
    //@RequiresPermissions("game:game:info")
    public Result gameInfo(@PathVariable("id") Long id) {
        GameInfoView game = gameService.gameInfo(id);
        return Result.ok().data("game", game);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:game:save")
    public Result save(@RequestBody GameEntity game) {
        gameService.save(game);
        return Result.ok().data("gameId", game.getId());
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:game:update")
    public Result update(@RequestBody GameEntity game) {
        gameService.updateById(game);

        return Result.ok();
    }

    /**
     * 删除 TODO: 删除游戏的同时删除游戏相关数据
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:game:delete")
    public Result delete(@RequestBody Long[] ids) {
        gameService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

    /**
     * 远程调用的接口
     *
     * @param ids
     * @return
     */
    @GetMapping("/gatGameNameByIdsForCommunity")
    public List<PageOfGameName> gatGameNameByIdsForCommunity(@RequestParam(value = "ids") List<Long> ids) {
        return gameService.gatGameNameByIdsForCommunity(ids);
    }

    /**
     * 获取首页的最新发布的游戏
     * @return
     */
    @GetMapping("/getNewReleaseGame")
    public Result getNewReleaseGame() {
        List<ReleaseOrHotGameList> result=gameService.getNewReleaseGame();
        return Result.ok().data("result",result);
    }

}
