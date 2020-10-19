package com.yaohuaxiang.serviceImpl;

import com.yaohuaxiang.bean.Comment;
import com.yaohuaxiang.mapper.CommentMapper;
import com.yaohuaxiang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/10/19 - 14:07
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> getAllCommentWithBlogId(Integer bid) {
        return commentMapper.getAllCommentWithBlogId(bid);
    }

    @Override
    public void addCommentToBlogWithBlogId(Integer bid, String content) {
        commentMapper.addCommentToBlogWithBlogId(bid,content);
    }
}
