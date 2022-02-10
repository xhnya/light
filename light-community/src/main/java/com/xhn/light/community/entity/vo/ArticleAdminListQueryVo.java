package com.xhn.light.community.entity.vo;

import lombok.Data;

/**
 * @author ：xhn
 * @date ：2022/2/10 11:28
 * @description： 管理后台的文章展示的查询参数
 */
@Data
public class ArticleAdminListQueryVo {

    private int page = 1;
    private int limit=10;

}
