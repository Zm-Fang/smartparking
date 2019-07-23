package com.terminator.smart.parking.service.impl;

import com.terminator.smart.parking.dao.NewsDao;
import com.terminator.smart.parking.entity.News;
import com.terminator.smart.parking.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@Description 消息 Service 接口实现类，实现具体的业务逻辑的方法
*@Author 方泽谋
*@DateTime 2019/7/22 14:04
*/
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> selectAll() {
        return newsDao.selectAll();
    }

    @Override
    public int insertNews(News news) {
        return newsDao.insertNews(news);
    }

    @Override
    public int deleteNewsByNewsId(int id) {
        return newsDao.deleteNewsByNewsId(id);
    }
}
