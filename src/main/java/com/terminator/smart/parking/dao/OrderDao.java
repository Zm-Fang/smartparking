package com.terminator.smart.parking.dao;

import com.terminator.smart.parking.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*@Description  订单dao，用于数据库交互
*@Author 胡兴成
*@DateTime 2019/7/23 11:21
*/
@Repository
public interface OrderDao {
    /**
     * 通过订单id查询返回订单信息
     * @param id
     * @return
     */
       Order selectId(int id);

    /**
     * 通过UserID查询用户所有订单
     * @param UserId
     * @return
     */
       List<Order> selectByUserId(int UserId);

    /**
     * 修改订单
     * @param order
     * @return
     */
       int update(Order order);



    /**
     * 伪删除订单
     * @param id
     * @return
     */
    int deleteByFlag(int id);

    /**
     * 已完成订单
     * @param id
     * @return
     */
    int success(int id);

    /**
     * 失效订单
     * @param id
     * @return
     */
    int loser(int id);

    /**
     * 预约成功订单
     * @param id
     * @return
     */
    int successful(int id);

    /**
     * 添加订单
     * @param order
     * @return
     */
    int insert(Order order);
}
