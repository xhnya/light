package com.xhn.light.wiki.vo;

import lombok.Data;

import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/21 11:22
 * @description：
 */
@Data
public class MenuListVo {
    private Long id;
    private Long pid;
    private String name;
    private String cover;
    private Integer editType;
    private Long parentId;
}
