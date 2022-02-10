package com.xhn.light.community.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhn.light.community.entity.ArticleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.light.community.entity.vo.ArticleAdminListQueryVo;
import com.xhn.light.community.entity.vo.ArticleAdminListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 社区文章表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@Mapper
public interface ArticleDao extends BaseMapper<ArticleEntity> {

    List<ArticleAdminListVo> selectPageAdminList(Page<ArticleEntity> page, ArticleAdminListQueryVo params);
}
