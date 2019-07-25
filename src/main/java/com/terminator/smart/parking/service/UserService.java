package com.terminator.smart.parking.service;

import com.terminator.smart.parking.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 2019/7/22 0022 11:20
 * @Version 1.0
 **/

public interface UserService {
   List<User> findUser(String username, String password);

   int updateUserInfo(User user);

   int insertUser(User user);


   List<User> selectAll();

   int deleteUserByUserId(int id);

   int resetUsernamePasswordByUserId(int id);
}
