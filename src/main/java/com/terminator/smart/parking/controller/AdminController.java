package com.terminator.smart.parking.controller;

import com.terminator.smart.parking.entity.News;
import com.terminator.smart.parking.entity.Opinion;
import com.terminator.smart.parking.entity.Parking;
import com.terminator.smart.parking.entity.User;
import com.terminator.smart.parking.service.NewsService;
import com.terminator.smart.parking.service.OpinionService;
import com.terminator.smart.parking.service.ParkingService;
import com.terminator.smart.parking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @Description 管理员 controller 层代码
 * @Author 方泽谋
 * @DateTime 2019/7/24 16:12
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ParkingService parkingService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private OpinionService opinionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/tofirst",method = RequestMethod.GET)
    public String tofirst() {
        return "first";
    }

    @RequestMapping(value = "/toAdminLogin",method = RequestMethod.GET)
    public String toAdminLogin() {
        return "adminlogin";
    }

    @RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
    public String adminLogin(String adminName, String password, ModelMap modelMap) {
        if ("admin".equals(adminName) && "admin".equals(password)) {
            return "redirect:/admin/toAdmin";
        }
        modelMap.addAttribute("msg", "管理员账号或密码错误");
        return "adminlogin";
    }

    @RequestMapping(value = "/toAdmin",method = RequestMethod.GET)
    public String toAdmin() {
        return "admin";
    }

    @RequestMapping(value = "/toAdminHome",method = RequestMethod.GET)
    public String toAdminHome() {
        return "adminhome";
    }

    /**
     * @Description 停车场相关业务 包括增、删、改、查
     * @Author 方泽谋
     * @DateTime 2019/7/24 16:13
     */
    /**
     * 查找所有停车场，展示在页面
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/toParking",method = RequestMethod.GET)
    public ModelAndView toParking(ModelAndView modelAndView) {
        modelAndView.setViewName("adminparking");
        List<Parking> parkings = parkingService.selectAll();
        modelAndView.addObject("parkingList", parkings);
        return modelAndView;
    }
    /**
     * 通过 id 删除停车场并跳转回停车场展示
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteParking", method = RequestMethod.GET)
    public String deleteParking(int id) {
        int i = parkingService.deleteParkingByParkingId(id);
        return "redirect:/admin/toParking";
    }
    /**
     * 通过 id 查找停车场并跳转到修改页修改停车场信息
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/toUpdateParking", method = RequestMethod.GET)
    public ModelAndView toUpdateParking(int id, ModelAndView modelAndView) {
        modelAndView.setViewName("updateparking");
        Parking parking = parkingService.selectParkingByParkingId(id);
        modelAndView.addObject("parking", parking);
        return modelAndView;
    }
    /**
     * 修改停车场信息并跳转回停车场展示
     * @param parking
     * @return
     */
    @RequestMapping(value = "/updateParking",method = RequestMethod.POST)
    public String updateParking(Parking parking) {
        int i = parkingService.updateParkingByParkingId(parking);
        return "redirect:/admin/toParking";
    }
    /**
     * 跳转到添加停车场
     * @return
     */
    @RequestMapping("/toAddParking")
    public String toAddParking() {
        return "addparking";
    }
    /**
     * 添加停车场并跳转回停车场展示
     * @return
     */
    @RequestMapping(value = "/addParking", method = RequestMethod.POST)
    public String addParking(Parking parking) {
        int i = parkingService.insertParking(parking);
        return "redirect:/admin/toParking";
    }


    /**
     * @Description 用户账号相关业务 包括查、改(重置)
     * @Author 方泽谋
     * @DateTime 2019/7/24 16:25
     */
    /**
     * 查找所有用户并展示
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/toUser",method = RequestMethod.GET)
    public ModelAndView toUser(ModelAndView modelAndView) {
        modelAndView.setViewName("adminuser");
        List<User> users = userService.selectAll();
        modelAndView.addObject("userList", users);
        return modelAndView;
    }
    /**
     * 通过 id 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(int id) {
        int i = userService.deleteUserByUserId(id);
        return "redirect:/admin/toUser";
    }
    /**
     * 通过 id 重置用户账号
     * @param id
     * @return
     */
    @RequestMapping(value = "/resetUser", method = RequestMethod.GET)
    public String resetUser(int id) {
        int i = userService.resetUsernamePasswordByUserId(id);
        return "redirect:/admin/toUser";
    }


    /**
     * @Description 系统消息相关业务 包括查、删、增
     * @Author 方泽谋
     * @DateTime 2019/7/24 16:54
     */
    /**
     * 查找所有系统消息并展示
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/toNews",method = RequestMethod.GET)
    public ModelAndView toNews(ModelAndView modelAndView) {
        modelAndView.setViewName("adminnews");
        List<News> news = newsService.selectAll();
        modelAndView.addObject("newsList", news);
        return modelAndView;
    }
    /**
     * 通过 id 删除消息
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteNews", method = RequestMethod.GET)
    public String deleteNews(String id) {
        int i = newsService.deleteNewsByNewsId(Integer.parseInt(id));
        return "redirect:/admin/toNews";
    }
    /**
     * 跳转到添加编辑系统消息
     * @return
     */
    @RequestMapping("/toAddNews")
    public String toAddNews() {
        return "addnews";
    }
    /**
     * 添加新的系统消息
     * @param news
     * @return
     */
    @RequestMapping(value = "/addNews",method = RequestMethod.POST)
    public String addNews(News news) {
        news.setNewsTime(new Date());
        int i = newsService.insertNews(news);
        return "redirect:/admin/toNews";
    }


    /**
     * @Description 意见反馈相关业务 包括查、删
     * @Author 方泽谋
     * @DateTime 2019/7/24 16:58
     */
    /**
     * 查找所有意见反馈并展示
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/toOpinion",method = RequestMethod.GET)
    public ModelAndView toOpinion(ModelAndView modelAndView) {
        modelAndView.setViewName("adminopinion");
        List<Opinion> opinions = opinionService.selectAll();
        modelAndView.addObject("opinionList", opinions);
        return modelAndView;
    }
    /**
     * 通过 id 删除意见反馈
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteOpinion", method = RequestMethod.GET)
    public String deleteOpinion(String id) {
        int i = opinionService.deleteOpinionByOpinionId(Integer.parseInt(id));
        return "redirect:/admin/toOpinion";
    }
}
