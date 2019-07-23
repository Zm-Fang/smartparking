package com.terminator.smart.parking.dao;

import com.terminator.smart.parking.entity.News;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*@Description 消息 dao 层，用于数据库交互
*@Author 方泽谋
*@DateTime 2019/7/22 14:01
*/
@Repository
public interface NewsDao {

    /**
    *@Description 查找所有消息
    *@return 消息集合
    *@Author 方泽谋
    *@DateTime 2019/7/22 14:22
    */
    List<News> selectAll();

    /**
    *@Description 通过用户 user_id 获取消息
    *@param id 用户user_id
    *@return 消息集合
    *@Author 方泽谋
    *@DateTime 2019/7/22 17:12
    */
    List<News> selectByUserId(int id);

    /**
    *@Description 新增一条消息
    *@param news 消息对象
    *@return 影响行数
    *@Author 方泽谋
    *@DateTime 2019/7/22 14:24
    */
    int insertNews(News news);

    /**
    *@Description 通过 News_id 删除消息
    *@param id News_id
    *@return 影响行数
    *@Author 方泽谋
    *@DateTime 2019/7/22 17:03
    */
    int deleteNewsByNewsId(int id);
}
