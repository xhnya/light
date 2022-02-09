package com.xhn.light.community.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 社区文章表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@Data
@TableName("cms_article")
public class ArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 所属社区的id
	 */
	private Long parentId;
	/**
	 * 用户id，外键
	 */
	private Long user;
	/**
	 * 
	 */
	private Integer catalog;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 关键字
	 */
	private String keywords;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 点击量
	 */
	private Integer clickNum;
	/**
	 * 发表日期
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 发布的类型，资讯或者社区
	 */
	private String publishType;
	/**
	 * 逻辑删除，1正常，0删除
	 */
	private Integer isDel;
	/**
	 * 文章封面图片
	 */
	private String coverImage;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 类型id
	 */
	private Long typeId;
	/**
	 * 是否推荐	
	 */
	private Integer recommended;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;
	/**
	 * 是否热门
	 */
	private Integer isHot;

}
