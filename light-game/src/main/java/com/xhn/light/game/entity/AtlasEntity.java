package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏图集
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:15
 */
@Data
@TableName("gms_atlas")
public class AtlasEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 图集名称
	 */
	private String atlasName;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 封面
	 */
	private String coverUrl;
	/**
	 * 
	 */
	private Integer isDel;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
