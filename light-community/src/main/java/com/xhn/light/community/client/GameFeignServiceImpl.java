package com.xhn.light.community.client;

import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.utils.Result;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/10 14:01
 * @description：
 */
@Component
public class GameFeignServiceImpl implements GameFeignService{

    @Override
    public List<PageOfGameName>  gatGameNameByIdsForCommunity(List<Long> ids) {

        return null;
    }
}
