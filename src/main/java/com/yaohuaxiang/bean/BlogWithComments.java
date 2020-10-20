package com.yaohuaxiang.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yaohuaxiang
 * @create 2020/10/20 - 14:09
 */
//使用这个类一次性获得博客对应的评论

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogWithComments {
    private Integer cid;
    private String title;
    private String content;
}
