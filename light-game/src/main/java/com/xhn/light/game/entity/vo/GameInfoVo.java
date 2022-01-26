package com.xhn.light.game.entity.vo;

import com.alibaba.nacos.shaded.io.opencensus.tags.Tags;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author xhn
 * @date 2022/1/26 20:14
 * @description: 后台游戏详情显示
 */
@Data
public class GameInfoVo {
    //游戏id
    private Long id;
    /**
     * 类型
     */
    private String typeName;
    /**
     * 制作商
     */
    private String gameMakingName;
    /**
     * 发行商
     */
    private String gameIssueName;

    /**
     * 详情视频
     */
    private String videoUrl;
    /**
     *
     */
    private Date createTime;
    private Date updateTime;
    /**
     * 背景图
     */
    private String bgUrl;
    /**
     * 是否热门
     */
    private Integer isHot;
    /**
     * 主要图片
     */
    private String imgUrl;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 中文名
     */
    private String gameNameChina;
    /**
     * 描述
     */
    private String gameDescribe;
    /**
     * 游戏名称
     */
    private String gameName;
    /**
     * 官网链接
     */
    private String website;
    /**
     * 封面图
     */
    private String coverUrl;
    /**
     * 发行时间
     */
    private Date releaseTime;

    private List<Tags> tags;


}
