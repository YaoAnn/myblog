package com.yaohuaxiang.mapper;

import com.yaohuaxiang.bean.Comment;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/10/19 - 13:51
 */
@Repository
public interface CommentMapper {
    @Select("select * from comments where bid = #{bid}")
    List<Comment> getAllCommentWithBlogId(Integer bid);
}
