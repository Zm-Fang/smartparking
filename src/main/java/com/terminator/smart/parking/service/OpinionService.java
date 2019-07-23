package com.terminator.smart.parking.service;

import com.terminator.smart.parking.entity.Opinion;

import java.util.List;

/**
*@Description 意见 Service 接口，定义处理消息相关的业务逻辑的方法
*@Author 方泽谋
*@DateTime 2019/7/22 19:58
*/
public interface OpinionService {

    List<Opinion> selectAll();

    int insertOpinion(Opinion opinion);

    int deleteOpinionByOpinionId(int id);
}
