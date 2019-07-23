package com.terminator.smart.parking.dao;

import com.terminator.smart.parking.entity.Opinion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*@Description 意见 dao 层，用于数据库交互
*@Author 方泽谋
*@DateTime 2019/7/22 19:52
*/
@Repository
public interface OpinionDao {

    /**
    *@Description 查找所有意见
    *@return 意见集合
    *@Author 方泽谋
    *@DateTime 2019/7/22 20:25
    */
    List<Opinion> selectAll();

    /**
    *@Description
    *@param opinion 意见对象
    *@return 影响行数
    *@Author 方泽谋
    *@DateTime 2019/7/22 20:25
    */
    int insertOpinion(Opinion opinion);

    /**
    *@Description 通过 Opinion_id 删除消息
    *@param id Opinion_id
    *@return 影响行数
    *@Author 方泽谋
    *@DateTime 2019/7/22 21:32
    */
    int deleteOpinionByOpinionId(int id);
}
