package com.yaohuaxiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yaohuaxiang
 * @create 2020/10/15 - 14:48
 */
@Controller
public class CommonController {

    @GetMapping({"/","/index","toindex"})
    public String toindex(){
        return "index";
    }

    @GetMapping("message.html")
    public String tomessage(){
        return "message";
    }

    @GetMapping("/about.html")
    public String toabout(){
        return "about";
    }


}
