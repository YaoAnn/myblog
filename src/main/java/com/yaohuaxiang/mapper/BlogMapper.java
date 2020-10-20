package com.yaohuaxiang.mapper;

import com.yaohuaxiang.bean.Blog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/10/19 - 10:35
 */
@Repository
public interface BlogMapper {
    @Select("select * from blogs")
    List<Blog> getAllBlog();

    @Select("select * from blogs where bid = #{bid}")
    Blog getBlogById(Integer bid);

    @Insert("insert into blogs(title,content) values(#{title},#{content})")
    void addBlog(String title , String content);

    @Delete("delete from blogs where bid =#{bid}")
    void deleteBlogById(Integer bid);

    @Update("update blogs set title = #{title} , content = #{content} where bid = #{bid}")
    void updateBlogById(Integer bid ,String title , String content);
}
