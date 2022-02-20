package com.xhn.light.community.entity.vo;

import lombok.Data;

/**
 * @author xhn
 * @date 2022/2/20 15:07
 * @description:
 */
@Data
public class CollectionMyParams {

    private Integer limit=10;
    private Integer page=1;
    private Long parentId;
}
