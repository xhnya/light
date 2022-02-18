package com.xhn.light.common.pojo;

import lombok.Data;

/**
 * @author xhn
 * @date 2022/2/18 21:40
 * @description:
 */
@Data
public class PageParam {
    private Integer page=1;
    private Integer limit=10;
}
