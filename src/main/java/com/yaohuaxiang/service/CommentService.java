package com.yaohuaxiang.service;

import com.yaohuaxiang.bean.Comment;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/10/19 - 14:06
 */
public interface CommentService {
    List<Comment> getAllCommentWithBlogId(Integer bid);
}
