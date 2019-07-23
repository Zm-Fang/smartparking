package com.terminator.smart.parking.service.impl;

import com.terminator.smart.parking.dao.UserDao;
import com.terminator.smart.parking.entity.User;
import com.terminator.smart.parking.service.UserService;
import com.terminator.smart.parking.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 2019/7/22 0022 11:21
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public List<User> findUser(String username, String password) {
        List<User> user = userDao.findUser(username, MD5Util.string2MD5(password));
        return user;
    }

    @Override
    public int updateUserInfo(User user) {
        return userDao.updateUserInfo(user);
    }

    @Override
    public int insertUser(User user) {
            return userDao.insertUser(user);
    }
}
