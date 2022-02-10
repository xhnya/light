package com.xhn.light.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.community.entity.ArticleEntity;
import com.xhn.light.community.entity.vo.ArticleAdminListQueryVo;

import java.util.Map;

/**
 * 社区文章表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
public interface ArticleService extends IService<ArticleEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils selectPageAdminList(ArticleAdminListQueryVo params);
}

