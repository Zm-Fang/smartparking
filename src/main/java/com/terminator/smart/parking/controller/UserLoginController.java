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

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String toRegister() {
        return "register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public String toSetting(HttpSession session, ModelMap modelMap) {
        User user = (User) session.getAttribute("USER_LOGIN");
        modelMap.addAttribute("USER_LOGIN", user);
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
    public String login(HttpServletResponse a,String username, String password, Model model, HttpSession session) {
        List<User> user = userService.findUser(username, password);

        if (user.size() != 0) {
            session.setAttribute("USER_LOGIN", user.get(0));
            model.addAttribute("user","欢迎您,"+user.get(0).getUsername());
            model.addAttribute("erro","退出");
            try {
                a.getWriter().write("1");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "index";
        } else {
            model.addAttribute("msg", "账号或密码错误，请重新输入！");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("USER_LOGIN");
        return "index";
    }
    /**
     * @Description 注册用户
     * @Author 杨志豪
     * @DateTime 2019/7/24 0024 10:08
     */

    @RequestMapping(value = "register1", method = RequestMethod.POST)
    public String addUser(User user) {
        System.out.println(user);
        int i = userService.insertUser(user);
        if (i > 0) {
            return "login";
        } else {
            return "register";
        }
    }

    /**
     * @Description 用户信息修改
     * @Author 杨志豪
     * @DateTime 2019/7/24 0024 10:11
     */
    @RequestMapping(value = "setting1", method = RequestMethod.POST)
    public String updateUserInfo(String username, String password, String phone, String licenseNumber, String
            email, HttpSession session) {
        User user = (User) session.getAttribute("USER_LOGIN");
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setLicenseNumber(licenseNumber);
        user.setEmail(email);
        int i = userService.updateUserInfo(user);
        session.setAttribute("USER_LOGIN", user);

        if (i == 1) {
            return "redirect:/user/setting";
        } else {

            return null;
        }
    }


    /**
     * @Description 检查用户名是否存在
     * @Author 杨志豪
     * @DateTime 2019/7/24 0024 10:07
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST)

    public void check(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("USER_LOGIN");
        System.out.println("=========="+user);
        if (user != null) {
            try {
                response.getWriter().write("1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                response.getWriter().write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




