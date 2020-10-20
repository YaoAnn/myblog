package com.yaohuaxiang.mapper;

import com.yaohuaxiang.bean.BlogWithComments;
import com.yaohuaxiang.bean.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("insert into comments values(null,#{content},#{bid})")
    void addCommentToBlogWithBlogId(Integer bid,String content);

    //获取所有博客对应的评论
    @Select("select b.title,c.cid,c.content from blogs b right join comments c on b.bid = c.bid")
    List<BlogWithComments> getAllComment();

    @Delete("delete from comments where cid = #{cid}")
    void deleteCommentById(Integer cid);
}
