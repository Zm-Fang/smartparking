package com.terminator.smart.parking.service;

import com.terminator.smart.parking.entity.News;

import java.util.List;

/**
*@Description 消息 Service 接口，定义处理消息相关的业务逻辑的方法
*@Author 方泽谋
*@DateTime 2019/7/22 14:02
*/
public interface NewsService {

    List<News> selectAll();

    List<News> selectByUserId(int id);

    List<News> selectSystemNews();

    int insertNews(News news);

    int deleteNewsByNewsId(int id);
}
