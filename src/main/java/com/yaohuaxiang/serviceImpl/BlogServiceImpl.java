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
}
