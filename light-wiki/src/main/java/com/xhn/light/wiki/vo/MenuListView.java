package com.xhn.light.wiki.vo;

import lombok.Data;

import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/21 11:05
 * @description：
 */
@Data
public class MenuListView {
    private Long id;
    private Long pid;
    private String name;
    private List<MenuListView> children;
    private String cover;
    private Integer editType;
}
