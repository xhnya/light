package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 奖项
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:16
 */
@Data
@TableName("gms_award")
public class AwardEntity implements Serializable {
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
	 * 年份
	 */
	private String year;
	/**
	 * 发奖机构
	 */
	private String institutionsName;
	/**
	 * 名称描述
	 */
	private String nameDescribe;
	/**
	 * 奖项名称
	 */
	private String awardName;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
