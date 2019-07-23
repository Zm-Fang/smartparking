package com.terminator.smart.parking.service;

import com.terminator.smart.parking.entity.Order;


public interface OrderService {
    /**
     * 根据id返回订单信息
     * @param id
     * @return
     */
    public Order selectId(int id);

    /**
     * 修改订单信息
     * @param order
     * @return
     */
    public int upadate(Order order);


    /**
     * 伪删除订单
     * @param order
     * @return
     */
    public int deleteByFlag(Order order);

    /**
     * 添加订单
     * @param order
     * @return
     */
    public int insert(Order order);
}
