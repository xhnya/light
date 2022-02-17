package com.xhn.light.community.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 社区表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-17 09:06:04
 */
@Data
@TableName("cms_community")
public class CommunityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 社区的类型，0游戏社区，1本站社区，2系统文章
	 */
	private Integer type;
	/**
	 * 社区名
	 */
	private String name;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 如果是游戏社区，则父id就是游戏的id，
	 */
	private Long parentId;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
