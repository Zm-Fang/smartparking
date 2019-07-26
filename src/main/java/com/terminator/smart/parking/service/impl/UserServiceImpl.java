package com.terminator.smart.parking.service.impl;

import com.terminator.smart.parking.dao.UserDao;
import com.terminator.smart.parking.dao.WalletDao;
import com.terminator.smart.parking.entity.User;
import com.terminator.smart.parking.entity.Wallet;
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
    @Autowired
    private WalletDao walletDao;
    @Autowired
    private Wallet wallet;

    @Override
    public List<User> findUser(String username, String password) {
        return userDao.findUser(username, password);
    }

    @Override
    public int updateUserInfo(User user) {
        return userDao.updateUserInfo(user);
    }

    @Override
    public int insertUser(User user)
    {
        int rSet = userDao.insertUser(user);
        if (rSet > 0)
        {
            System.out.println(user.getUsername());
            List<User> list = userDao.getUserByUserName(user.getUsername());
            System.out.println(list.get(0).getUserId());
            wallet.setUserId(list.get(0).getUserId());
            wallet.setWalletBalance(0.00);
            walletDao.insertWallet(wallet);
        }
        return rSet;
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }


    @Override
    public int deleteUserByUserId(int id) {
        return userDao.deleteUserByUserId(id);
    }

    @Override
    public int resetUsernamePasswordByUserId(int id) {
        return userDao.resetUsernamePasswordByUserId(id);
    }

    @Override
    public List<User> getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
