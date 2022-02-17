package com.xhn.light.game.client;

import com.xhn.light.common.utils.Result;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ：xhn
 * @date ：2022/2/17 9:16
 * @description：
 */
@Component
public class AddCommunityFeignImpl implements AddCommunityFeign{
    @Override
    public Result saveFromGame(Map<String, Object> params) {
        return Result.error().message("社区生成失败");
    }
}
