package com.xhn.light.wiki.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 百科菜单表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-21 10:18:51
 */
@Data
@TableName("wms_menu")
public class MenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 菜单名
	 */
	private String name;
	/**
	 * 父id
	 */
	private Long parentId;
	/**
	 * 游戏id
	 */
	private Long gid;
	/**
	 * 页面id
	 */
	private Long pid;
	/**
	 * 菜单的级别
	 */
	private Integer level;
	/**
	 * 封面
	 */
	private String cover;
	/**
	 * 编辑类型 0=可编辑 1=不允许编辑
	 */
	private Integer editType;
	/**
	 * 创建人ID
	 */
	private Long createUserId;
	/**
	 * 创建人名字
	 */
	private String createUserName;
	/**
	 * 修改人ID
	 */
	private Long updateUserId;
	/**
	 * 修改人名字
	 */
	private String updateUserName;
	/**
	 * 0=有效 1=删除
	 */
	private Integer delFlag;
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
