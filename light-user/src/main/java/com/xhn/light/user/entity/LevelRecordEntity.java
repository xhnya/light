package com.xhn.light.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户等级记录表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@Data
@TableName("ums_level_record")
public class LevelRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 获得时间
	 */
	private Date gainTime;
	/**
	 * 来源名称
	 */
	private Long gainForm;
	/**
	 * 来源活动标题
	 */
	private String gainTitle;
	/**
	 * 获取积分数
	 */
	private Long gainNums;
	/**
	 * 获取之前数
	 */
	private Long gainBefore;
	/**
	 * 获取之后
	 */
	private Long gainAfter;
	/**
	 * 
	 */
	private Date createTime;

}
