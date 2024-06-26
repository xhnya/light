package com.xhn.light.common.es;

import lombok.Data;

import java.util.List;

/**
 * @author xhn
 * @date 2022/2/22 22:03
 * @description:
 */
@Data
public class ElasticSearchModel {
    private Long id;
    private String name;
    /**
     * 用户0，游戏1，文章2, 百科3
     */
    private Integer typeSearch;
    private Integer hotScore;
    private List<Attrs> attrs;

    @Data
    public static class Attrs{
        private String gameType;
        private String pageType;
    }
}
