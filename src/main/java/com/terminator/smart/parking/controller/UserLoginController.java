package com.terminator.smart.parking.controller;

import com.terminator.smart.parking.entity.User;
import com.terminator.smart.parking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 2019/7/23 0023 19:23
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String toIndex()
    {
        return "index";
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String toRegister()
    {
        return "register";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin()
    {
        return "login";
    }

    @RequestMapping(value = "/setting",method = RequestMethod.GET)
    public String toSetting(HttpSession session,ModelMap modelMap){
        User user= (User) session.getAttribute("USER_LOGIN");
        modelMap.addAttribute("USER_LOGIN",user);
        return "setting";
    }

    /**
     * 登录逻辑
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "login1", method = RequestMethod.POST)
    public String login(String username, String password, Model model, HttpSession session) {
        List<User> user = userService.findUser(username, password);
        System.out.println(username);
        System.out.println(password);
        if (user.size() != 0) {
            session.setAttribute("USER_LOGIN", user.get(0));
                model.addAttribute("msg","欢迎您,"+""+user.get(0).getUsername());
            return "index";
        } else {
            model.addAttribute("msg", "账号或密码错误，请重新输入！");
            return "login";
        }
    }
        /**
         *@Description 注册用户
         *@Author 杨志豪
         *@DateTime 2019/7/24 0024 10:08
         */

        @RequestMapping(value = "register1", method = RequestMethod.POST)
        public String addUser (User user){
            System.out.println(user);
            int i = userService.insertUser(user);
            if (i > 0)
            {
                return "login";
            }
            else
            {
                return "register";
            }
        }

        /**
         *@Description 用户信息修改
         *@Author 杨志豪
         *@DateTime 2019/7/24 0024 10:11
         */
        @RequestMapping(value = "setting1", method = RequestMethod.POST)
        @ResponseBody
        public String updateUserInfo (String username, String password, String phone, String licenseNumber, String
        email, HttpSession session){
            User user = (User) session.getAttribute("USER_LOGIN");
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone(phone);
            user.setLicenseNumber(licenseNumber);
            user.setEmail(email);
            int i = userService.updateUserInfo(user);
            session.setAttribute("USER_LOGIN", user);
            String msg = null;
            if (i == 1) {
               return "setting";
            } else {
                msg="flase";
                return msg;
            }
        }



         @RequestMapping(value = "/ajaxCheckLogin",method = RequestMethod.POST)
         public void ajaxCheckLogin(HttpServletRequest request,HttpServletResponse response){
             User user = (User) request.getSession().getAttribute("USER_LOGIN");
             if (user==null){
                 try {
                     response.getWriter().write("0");
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }else {
                 try {
                     response.getWriter().write("1");
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }


    }

        /**
         *@Description 检查用户名是否存在
         *@Author 杨志豪
         *@DateTime 2019/7/24 0024 10:07
         */
/*
        @RequestMapping(value = "/checkUsername.action", method = RequestMethod.POST)
        @ResponseBody
        public boolean checkUsername(String username) {
            User u = userService.findByUsername(username);
            if (u != null) {
                return false;
            }
            return true;
        }*/




