package com.terminator.smart.parking.entity;

import java.util.Date;

/**
*@Description 消息实体类
*@Author 方泽谋
*@DateTime 2019/7/22 14:01
*/
public class News {
    private int newsId;
    private String newsTitle;
    private String newsBody;
    private Date newsTime;
    private String newsType;
    private int userId;
    private String username;
    private int newsFlag;

    public News() {
    }

    public News(int newsId, String newsTitle, String newsBody, Date newsTime, String newsType, int userId, String username, int newsFlag) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsBody = newsBody;
        this.newsTime = newsTime;
        this.newsType = newsType;
        this.userId = userId;
        this.username = username;
        this.newsFlag = newsFlag;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public int getNewsFlag() {
        return newsFlag;
    }

    public void setNewsFlag(int newsFlag) {
        this.newsFlag = newsFlag;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsBody='" + newsBody + '\'' +
                ", newsTime=" + newsTime +
                ", newsType='" + newsType + '\'' +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", newsFlag=" + newsFlag +
                '}';
    }
}
