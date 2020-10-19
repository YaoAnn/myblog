package com.yaohuaxiang.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yaohuaxiang
 * @create 2020/10/19 - 21:44
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Integer mid;
    private String content;
}
