package com.yaohuaxiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yaohuaxiang
 * @create 2020/10/15 - 14:48
 */
@Controller
public class CommonController {

    @GetMapping({"/","/index","toindex",""})
    public String toindex(){
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

    @GetMapping("/details.html")
    public String todetails(){
        return "/views/details";
    }
}
