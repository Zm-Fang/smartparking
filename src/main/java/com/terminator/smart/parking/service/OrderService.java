package com.terminator.smart.parking.service;

import com.terminator.smart.parking.entity.Order;

import java.util.List;


public interface OrderService {
    /**
     * 根据订单id返回订单信息
     * @param id
     * @return
     */
    public Order selectId(int id);

    /**
     * 根据用户id查询该用户所有订单信息
     * @param UserId
     * @return
     */
    public List<Order> selectByUserId(int UserId);

    /**
     * 修改订单信息
     * @param order
     * @return
     */
    public boolean update(Order order);


    /**
     * 伪删除订单
     * @param id
     * @return
     */
    public int deleteByFlag(int id);

    /**
     * 已完成订单
     * @param id
     * @return
     */
    public int success(int id);

    /**
     * 已失效订单
     * @param id
     * @return
     */
    public int loser(int id);

    /**
     * 预约成功订单
     * @param id
     * @return
     */
    public int successful(int id);
    /**
     * 添加订单
     * @param order
     * @return
     */
    public int insert(Order order);
}
