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




    /**
     * @Description 管理员查找所有用户
     * @Author 方泽谋
     * @DateTime 2019/7/23 23:53
     */
    List<User> selectAll();
    /**
     * @Description 管理员通过 id 删除用户
     * @Author 方泽谋
     * @DateTime 2019/7/24 14:23
     */
    int deleteUserByUserId(int id);
    /**
     * @Description 管理员通过 id 重置用户
     * @Author 方泽谋
     * @DateTime 2019/7/24 16:40
     */
    int resetUsernamePasswordByUserId(int id);
}
