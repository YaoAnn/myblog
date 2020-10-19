package com.yaohuaxiang.mapper;

import com.yaohuaxiang.bean.Blog;
import org.apache.ibatis.annotations.Select;
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
}
