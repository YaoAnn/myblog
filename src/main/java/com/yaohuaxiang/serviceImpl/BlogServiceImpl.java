package com.yaohuaxiang.serviceImpl;

import com.yaohuaxiang.bean.Blog;
import com.yaohuaxiang.mapper.BlogMapper;
import com.yaohuaxiang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/10/19 - 10:37
 */

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<Blog> getAllBlog() {
        return blogMapper.getAllBlog();
    }

    @Override
    public Blog getBlogById(Integer bid) {
        return blogMapper.getBlogById(bid);
    }

    @Override
    public void addBlog(String title, String content) {
        blogMapper.addBlog(title,content);
    }

    @Override
    public void deleteBlogById(Integer bid) {
        blogMapper.deleteBlogById(bid);
    }

    @Override
    public void updateBlogById(Integer bid, String title, String content) {
        blogMapper.updateBlogById(bid,title,content);
    }
}
