package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏同系列
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
@Data
@TableName("gms_series")
public class SeriesEntity implements Serializable {
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
	 * 系列
	 */
	private Long seriesId;

}
