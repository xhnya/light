package com.xhn.light.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhn.light.community.entity.vo.CollectionMyParams;
import com.xhn.light.community.entity.vo.CommentView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.community.dao.CommentDao;
import com.xhn.light.community.entity.CommentEntity;
import com.xhn.light.community.service.CommentService;


@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, CommentEntity> implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommentEntity> page = this.page(
                new Query<CommentEntity>().getPage(params),
                new QueryWrapper<CommentEntity>().eq("parent_id", 0)
                        .eq("is_delete", 0).eq("aid", params.get("aid"))
                        .orderByDesc("create_time")
        );


        return new PageUtils(page);
    }

    public PageUtils getCommentList(CollectionMyParams params) {
        Page<CommentEntity> page = new Page<>(params.getPage(),params.getLimit());
        List<CommentView> result=commentDao.getCommentList(page,params.getParentId());
        return new PageUtils(result,(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent());
    }


    /**
     * 循环每个顶级的评论节点
     * 设置顶级节点
     */
    private List<CommentView> eachComment(List<CommentView> rootComment,List<CommentView> comments) {
        List<CommentView> commentsView = new ArrayList<>();
        for (CommentView comment : rootComment) {
            CommentView c = new CommentView();
            BeanUtils.copyProperties(comment, c);
            commentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(commentsView,comments);
        return commentsView;
    }

    /**
     * 设置子节点，
     * 一共有两个数据
     * 一个是根结点
     * 设置子节点
     * 并且
     * 首先遍历根结点
     * 找到一级子节点
     * 在遍历一级子节点
     *
     *
     * @param commentsView
     * @param comments
     */
    private void combineChildren(List<CommentView> commentsView, List<CommentView> comments) {
        for (CommentView comment : comments) {
            if (comment.getParentId()!=0){
                recursively(comment,comments);
            }
        }
    }
    //存放迭代找出的所有子代的集合
    private List<CommentView> tempReplys = new ArrayList<>();
    /**
     * 递归迭代，剥洋葱被迭代的对象
     */
    private void recursively(CommentView commentView, List<CommentView> comment) {
        for (CommentView view : comment) {
            if (view.getParentId()!=0){
                if (view.getParentId()!=commentView.getId()){
                    recursively(commentView,comment);
                }
            }
        }

    }






}