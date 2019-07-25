package com.terminator.smart.parking.service.impl;

import com.terminator.smart.parking.dao.OrderDao;
import com.terminator.smart.parking.entity.Order;
import com.terminator.smart.parking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public Order selectId(int id) {
        return orderDao.selectId(id);
    }

    @Override
    public List<Order> selectByUserId(int UserId) {
        return orderDao.selectByUserId(UserId);
    }

    @Override
    public boolean update(Order order) {
        int update = orderDao.update(order);
        if (update!=0){
            return true;
        }
        return false;
    }


    @Override
    public int deleteByFlag(int id) {
        return orderDao.deleteByFlag(id);
    }

    @Override
    public int success(int id) {
        return  orderDao.success(id);
    }

    @Override
    public int loser(int id) {
        return  orderDao.loser(id);
    }

    @Override
    public int successful(int id) {
        return orderDao.successful(id);
    }

    @Override
    public int insert(Order order) {
        return orderDao.insert(order);
    }

}
