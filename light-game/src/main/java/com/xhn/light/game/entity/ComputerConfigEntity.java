package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏配置表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:15
 */
@Data
@TableName("gms_computer_config")
public class ComputerConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 最低配置和推荐配置，最低为0，推荐为1
	 */
	private Integer type;
	/**
	 * 游戏id
	 */
	private Long gameId;
	/**
	 * 操作系统
	 */
	private String systemOs;
	/**
	 * 内存
	 */
	private String computerRam;
	/**
	 * 显卡
	 */
	private String computerVram;
	/**
	 * cpu
	 */
	private String computerCpu;
	/**
	 * 硬盘
	 */
	private String computerHard;
	/**
	 * 网络
	 */
	private String computerNetwork;

}
