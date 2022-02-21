package com.xhn.light.wiki.vo;

import lombok.Data;

/**
 * @author xhn
 * @date 2022/2/21 20:42
 * @description:
 */
@Data
public class SaveMenuAndPageParam {
    private Long menuId;
    private Long gameId;
    private String title;
    private String cover;
    private String content;

}
