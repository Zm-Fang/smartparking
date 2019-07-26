package com.terminator.smart.parking.controller;

import com.terminator.smart.parking.entity.News;
import com.terminator.smart.parking.entity.Order;
import com.terminator.smart.parking.entity.User;
import com.terminator.smart.parking.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Description 消息 Controller 层代码
 * @Author 方泽谋
 * @DateTime 2019/7/26 1:17
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("selectAllSystemNews")
    public ModelAndView selectAllSystemNews(ModelAndView modelAndView) {
        modelAndView.setViewName("news");
        List<News> news = newsService.selectSystemNews();
        modelAndView.addObject("newsList", news);
        return modelAndView;
    }

    @RequestMapping("selectByUserId")
    public ModelAndView selectByUserId(HttpSession session, ModelAndView modelAndView) {
        User user = (User) session.getAttribute("USER_LOGIN");
        modelAndView.setViewName("news");
        List<News> news = newsService.selectByUserId(user.getUserId());
        modelAndView.addObject("newsList", news);
        return modelAndView;
    }

    @RequestMapping(value = "deleteNews", method = RequestMethod.POST)
    public String deleteNews(String newsType, int id) {
        int i = newsService.deleteNewsByNewsId(id);
        if ("系统消息".equals(newsType)) {
            return "redirect:/news/selectAllSystemNews";
        }
        return "redirect:/news/selectByUserId";
    }

    @RequestMapping("addOrderNews")
    public String addOrderNews(HttpSession session) {
        Order order = (Order) session.getAttribute("order");
        User user = (User) session.getAttribute("USER_LOGIN");

        News news = new News();
        news.setNewsTitle("订单");
        news.setNewsBody("您好，"+ order.getUsername() +"，您在 " + order.getParkingName() + " 停车场预定了 " + order.getStartTime() + " 到 " + order.getStopTime() +"车位");
        news.setNewsTime(new Date());
        news.setNewsType("订单消息");
        news.setUserId(user.getUserId());
        news.setUsername(user.getUsername());

        int i = newsService.insertNews(news);

        return "redirect:/order/insert";
    }
}
