package com.xhn.light.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 收藏夹内容
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@Data
@TableName("ums_collection")
public class CollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 所属的收藏夹
	 */
	private Long parentId;
	/**
	 * 收藏的id
	 */
	private Long contentId;
	/**
	 * 
	 */
	private Integer isDel;
	/**
	 * 
	 */
	private Integer start;
	/**
	 * 
	 */
	private Date createTime;

}
