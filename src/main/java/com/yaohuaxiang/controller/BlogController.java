package com.yaohuaxiang.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yaohuaxiang.bean.Blog;
import com.yaohuaxiang.bean.Comment;
import com.yaohuaxiang.bean.Message;
import com.yaohuaxiang.service.BlogService;
import com.yaohuaxiang.service.CommentService;
import com.yaohuaxiang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @Autowired
    MessageService messageService;

    @GetMapping({"/","/index","toindex",""})
    public String toindex(Model model){
        List<Blog> blogs = blogService.getAllBlog();
        model.addAttribute("blogs",blogs);
        return "/views/index";
    }

    @RequestMapping("message.html")
    public String tomessage(String content , Model model){
        if(content !=null && content.length() != 0){
            messageService.addMessage(content);
        }
        List<Message> messages = messageService.getAllMessage();
        model.addAttribute("messages",messages);
        return "/views/message";
    }

    @GetMapping("/about.html")
    public String toabout(){
        return "/views/about";
    }

    @GetMapping("/comment.html")
    public String tocomment(Integer bid , Model model){
        model.addAttribute("bid",bid);
        return "/views/comment";
    }

    @RequestMapping("/details.html/{bid}")
    public String todetails(@PathVariable("bid")Integer bid,Model model ,String content){
        if(content!=null && content.length()!=0){
            commentService.addCommentToBlogWithBlogId(bid,content);
        }
        Blog blog = blogService.getBlogById(bid);
        List<Comment> comments = commentService.getAllCommentWithBlogId(bid);
        model.addAttribute("blog",blog);
        model.addAttribute("comments",comments);
        return "/views/details";
    }
}
