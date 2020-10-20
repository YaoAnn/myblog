package com.yaohuaxiang.service;

import com.yaohuaxiang.bean.Blog;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/10/19 - 10:37
 */
public interface BlogService {
    List<Blog> getAllBlog();
    Blog getBlogById(Integer bid);
    void addBlog(String title , String content);
    void deleteBlogById(Integer bid);
    void updateBlogById(Integer bid ,String title , String content);
}
