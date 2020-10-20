package com.yaohuaxiang.service;

import com.yaohuaxiang.bean.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/10/19 - 21:52
 */
public interface MessageService {
    List<Message> getAllMessage();
    void addMessage(String content);
    void deleteMessageById(Integer mid);
}
