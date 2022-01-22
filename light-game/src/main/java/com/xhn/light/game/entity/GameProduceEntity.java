package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏产商的游戏
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:15
 */
@Data
@TableName("gms_game_produce")
public class GameProduceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 
	 */
	private Long gameId;
	/**
	 * 
	 */
	private Long bid;
	/**
	 * 是否佳作
	 */
	private Integer isHot;

}
