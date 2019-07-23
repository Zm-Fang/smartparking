package com.terminator.smart.parking.dao;

import com.terminator.smart.parking.entity.Order;
import org.springframework.stereotype.Repository;

/**
*@Description  订单dao，用于数据库交互
*@Author 胡兴成
*@DateTime 2019/7/23 11:21
*/
@Repository
public interface OrderDao {
    /**
     * 通过id查询返回订单信息
     * @param id
     * @return
     */
       Order selectId(int id);

    /**
     * 修改订单
     * @param order
     * @return
     */
       int update(Order order);



    /**
     * 伪删除订单
     * @param order
     * @return
     */
    int deleteByFlag(Order order);

    /**
     * 添加订单
     * @param order
     * @return
     */
    int insert(Order order);
}
