package com.yaohuaxiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yaohuaxiang
 * @create 2020/10/16 - 12:57
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @GetMapping({"","/login.html"})
    public String toManager(){
        return "/manager/login";
    }

    @RequestMapping("/index.html")
    public String toManagerIndex(){
        return "/manager/index";
    }

    @RequestMapping("/comment.html")
    public String toManagerComment(){
        return "/manager/comment";
    }

    @RequestMapping("/about.html")
    public String toManagerAbout(){
        return "/manager/about";
    }

    @RequestMapping("/message.html")
    public String toManagerMessage(){
        return "/manager/message";
    }

}
