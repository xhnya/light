package com.xhn.light.community.entity.vo;

import lombok.Data;

/**
 * @author ：xhn
 * @date ：2022/2/14 10:26
 * @description： 社区主界面的文章列表显示传入的参数
 */
@Data
public class CommunityIndexListParam {
    private Integer limit=10;
    private Integer page=1;
}
