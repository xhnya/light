package com.xhn.light.community.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 标签表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@Data
@TableName("cms_tags")
public class TagsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 逻辑删除
	 */
	private Integer isDel;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 标签名
	 */
	private String tagName;
	/**
	 * 
	 */
	private Date createTime;

}
