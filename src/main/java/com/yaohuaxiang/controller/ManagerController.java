package com.yaohuaxiang.controller;

import com.yaohuaxiang.bean.Blog;
import com.yaohuaxiang.bean.BlogWithComments;
import com.yaohuaxiang.bean.Comment;
import com.yaohuaxiang.bean.Message;
import com.yaohuaxiang.service.BlogService;
import com.yaohuaxiang.service.CommentService;
import com.yaohuaxiang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/index.html")
    public String toManagerIndex(Model model){
        List<Blog> blogs = blogService.getAllBlog();
        model.addAttribute("blogs",blogs);
        return "/manager/index";
    }

    @PostMapping(value = "/addBlog")
    public String addBlog(String title,String content){
        if(title != null && title.length()!=0 && content!=null & content.length()!=0){
            blogService.addBlog(title,content);
        }
        return "redirect:/manager/index.html";
    }

    @PostMapping(value = "/updateBlog/{bid}")
    public String updateBlog(@PathVariable("bid") Integer bid , String title , String content){
        if(title != null && title.length()!=0 && content!=null & content.length()!=0){
            blogService.updateBlogById(bid,title,content);
        }
        return "redirect:/manager/index.html";
    }

    @GetMapping(value = "/deleteBlog/{bid}")
    public String deleteBlogById(@PathVariable("bid")Integer bid,Model model){
        blogService.deleteBlogById(bid);
        List<Blog> blogs = blogService.getAllBlog();
        model.addAttribute("blogs",blogs);
        return "redirect:/manager/index.html";
    }

    @GetMapping("/addBlog.html")
    public String toManagerAddBlog(){
        return "/manager/addBlog";
    }

    @GetMapping("/updateBlog.html")
    public String toManagerUpdateBlog(Model model,@RequestParam("bid") Integer bid){
        Blog blog = blogService.getBlogById(bid);
        model.addAttribute("blog",blog);
        return "/manager/updateBlog";
    }

    @GetMapping("/comment.html")
    public String toManagerComment(Model model){
        List<BlogWithComments> comments = commentService.getAllComment();
        model.addAttribute("comments",comments);
        return "/manager/comment";
    }

    @GetMapping("/deleteComment/{cid}")
    public String deleteCommentById(@PathVariable("cid") Integer cid){
        commentService.deleteCommentById(cid);
        return "redirect:/manager/comment.html";
    }


    @GetMapping("/deleteMessage/{mid}")
    public String deleteMessageById(@PathVariable("mid") Integer mid){
        messageService.deleteMessageById(mid);
        return "redirect:/manager/message.html";
    }


    @GetMapping("/message.html")
    public String toManagerMessage(Model model){
        List<Message> messages = messageService.getAllMessage();
        model.addAttribute("messages",messages);
        return "/manager/message";
    }

    /*@GetMapping("/about.html")
    public String toManagerAbout(){
        return "/manager/about";
    }*/
}
