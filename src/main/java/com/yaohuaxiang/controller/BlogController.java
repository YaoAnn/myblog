package com.yaohuaxiang.controller;

import com.yaohuaxiang.bean.Blog;
import com.yaohuaxiang.bean.Comment;
import com.yaohuaxiang.service.BlogService;
import com.yaohuaxiang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/10/15 - 14:48
 */
@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;

    @GetMapping({"/","/index","toindex",""})
    public String toindex(Model model){
        List<Blog> blogs = blogService.getAllBlog();
        model.addAttribute("blogs",blogs);
        return "/views/index";
    }

    @GetMapping("message.html")
    public String tomessage(){
        return "/views/message";
    }

    @GetMapping("/about.html")
    public String toabout(){
        return "/views/about";
    }

    @GetMapping("/comment.html")
    public String tocomment(){
        return "/views/comment";
    }

    @GetMapping("/details.html/{bid}")
    public String todetails(@PathVariable("bid")Integer bid,Model model){
        Blog blog = blogService.getBlogById(bid);
        List<Comment> comments = commentService.getAllCommentWithBlogId(bid);
        model.addAttribute("blog",blog);
        model.addAttribute("comments",comments);
        return "/views/details";
    }
}
