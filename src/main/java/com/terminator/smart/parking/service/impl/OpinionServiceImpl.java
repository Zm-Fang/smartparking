package com.terminator.smart.parking.service.impl;

import com.terminator.smart.parking.dao.OpinionDao;
import com.terminator.smart.parking.entity.Opinion;
import com.terminator.smart.parking.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@Description 意见 Service 接口实现类，实现具体的业务逻辑的方法
*@Author 方泽谋
*@DateTime 2019/7/22 20:11
*/
@Service
public class OpinionServiceImpl implements OpinionService {
    @Autowired
    private OpinionDao opinionDao;

    @Override
    public List<Opinion> selectAll() {
        return opinionDao.selectAll();
    }

    @Override
    public int insertOpinion(Opinion opinion) {
        return opinionDao.insertOpinion(opinion);
    }

    @Override
    public int deleteOpinionByOpinionId(int id) {
        return opinionDao.deleteOpinionByOpinionId(id);
    }
}
