package com.yaohuaxiang.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yaohuaxiang
 * @create 2020/10/19 - 13:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Integer cid;
    private String content;
    private Integer bid;
}
