package com.terminator.smart.parking.service.impl;

import com.terminator.smart.parking.dao.OrderDao;
import com.terminator.smart.parking.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderDao {
    @Autowired private OrderDao orderDao;
    @Override
    public Order selectId(int id) {
        return orderDao.selectId(id);
    }

    @Override
    public int update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public int deleteByFlag(Order order) {
        return orderDao.deleteByFlag(order);
    }

    @Override
    public int insert(Order order) {
        return orderDao.insert(order);
    }

}
