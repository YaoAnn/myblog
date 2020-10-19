package com.yaohuaxiang.controller;

import com.yaohuaxiang.bean.Blog;
import com.yaohuaxiang.bean.Comment;
import com.yaohuaxiang.service.BlogService;
import com.yaohuaxiang.service.CommentService;
import com.yaohuaxiang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/10/16 - 12:57
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;
    @Autowired
    MessageService messageService;

    @RequestMapping("")
    public String toManagerLogin(){
        return "/manager/login";
    }

    @RequestMapping("/index.html")
    public String toManagerIndex(Model model){
        List<Blog> blogs = blogService.getAllBlog();
        model.addAttribute("blogs",blogs);
        return "/manager/index";
    }

    @GetMapping("/comment.html")
    public String toManagerComment(){
        return "/manager/comment";
    }

    @GetMapping("/about.html")
    public String toManagerAbout(){
        return "/manager/about";
    }

    @GetMapping("/message.html")
    public String toManagerMessage(){
        return "/manager/message";
    }

}
