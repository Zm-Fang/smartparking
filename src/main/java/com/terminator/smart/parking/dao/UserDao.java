package com.terminator.smart.parking.dao;

import com.terminator.smart.parking.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {

    /**
    *@Description 用户名密码登录
    *@Author 杨志豪
    *@DateTime 2019/7/22 0022 17:00r
    */
    List<User> findUser(@Param("username") String username
            , @Param("password") String password);
    
    //注册用户
    int insertUser(User user);

    //修改用户信息
    int updateUserInfo(User user);

    User getById(long id);
}
