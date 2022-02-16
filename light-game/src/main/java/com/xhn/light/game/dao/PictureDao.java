package com.xhn.light.game.dao;

import com.xhn.light.game.entity.PictureEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 游戏图片
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:16
 */
@Mapper
public interface PictureDao extends BaseMapper<PictureEntity> {

    List<String> getGameInfoList(Long id);
}
