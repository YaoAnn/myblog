package com.yaohuaxiang.mapper;

import com.yaohuaxiang.bean.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/10/19 - 21:50
 */

@Repository
public interface MessageMapper {
    @Select("select * from messages")
    List<Message> getAllMessage();

    @Insert("insert into messages values(null , #{content})")
    void addMessage(String content);

    @Delete("delete from messages where mid = #{mid}")
    void deleteMessageById(Integer mid);
}
