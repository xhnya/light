package com.xhn.light.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户关注的游戏的统计
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-19 22:35:46
 */
@Data
@TableName("ums_user_count")
public class UserCountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 
	 */
	private Long uid;
	/**
	 * 数量
	 */
	private Integer nums;
	/**
	 * 类型（0是游戏，1是文章）
	 */
	private Integer type;

}
