package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.utils.JwtUtils;
import com.xhn.light.game.client.AddCommunityFeign;
import com.xhn.light.game.entity.vo.*;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.game.entity.GameEntity;
import com.xhn.light.game.service.GameService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;

import javax.servlet.http.HttpServletRequest;


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
    @Autowired
    private AddCommunityFeign addCommunityFeign;

    @Autowired
    private AmqpTemplate rabbitTemplate;

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
        Map<String, Object> map = new HashMap<>();
        map.put("id", game.getId());
        map.put("name", game.getGameNameChina());
        rabbitTemplate.convertAndSend("es_game",map);
        addCommunityFeign.saveFromGame(map);
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
     *
     * @return
     */
    @GetMapping("/getNewReleaseGame")
    public Result getNewReleaseGame() {
        List<ReleaseOrHotGameList> result = gameService.getNewReleaseGame();
        return Result.ok().data("result", result);
    }

    /**
     * 获取分类页的最近游戏，判断用户有没有登录，如果登录就返回历史或者关注的游戏
     * TODO: 最近游戏显示
     * @return
     */
    @GetMapping("/reqMyGameList")
    public Result getMyGameList(HttpServletRequest request) {
        String info = JwtUtils.getUserInfoByJwtToken(request);
//        if (info.equals("")){
//        }
        List<ReleaseOrHotGameList> result = gameService.getNewReleaseGame();
        return Result.ok().data("result", result);
    }

    /**
     *
     * 分类顶端的文本游戏的显示
     *
     * @param id 分类的id
     * @return
     */
    @GetMapping("/getGameTypeForType")
    public Result getGameTypeForType(@RequestParam Long id) {
        List<TypeGameListView> result = gameService.getGameTypeForType(id);
        return Result.ok().data("result", result);
    }

    @GetMapping("/getGameTypeForTypeTop")
    public Result getGameTypeForTypeTop(@RequestParam Long id) {
        List<TypeGameListView> result = gameService.getGameTypeForTypeTop(id);
        return Result.ok().data("result", result);
    }

    /**
     * 获取所有的游戏显示
     * @return
     */
    @GetMapping("/getAllGameList")
    public Result getAllGameList() {
        List<AllGameListView> result = gameService.getAllGameList();
        return Result.ok().data("result", result);
    }

    @GetMapping("/getWikiGameList")
    public Result getWikiGameList() {
        List<RecommendListView> result = gameService.getWikiGameList();
        return Result.ok().data("result", result);
    }
}
