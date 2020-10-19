package com.yaohuaxiang.serviceImpl;

import com.yaohuaxiang.bean.Message;
import com.yaohuaxiang.mapper.MessageMapper;
import com.yaohuaxiang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/10/19 - 21:53
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Override
    public List<Message> getAllMessage() {
        return messageMapper.getAllMessage();
    }

    @Override
    public void addMessage(String content) {
        messageMapper.addMessage(content);
    }
}
