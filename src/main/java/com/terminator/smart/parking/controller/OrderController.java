package com.terminator.smart.parking.controller;
import com.terminator.smart.parking.entity.Order;
import com.terminator.smart.parking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 添加订单
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/insert")
    public String insert(HttpServletRequest request,ModelMap modelMap) {
        Order order = (Order) request.getSession().getAttribute("order");
        orderService.insert(order);
        modelMap.addAttribute("order",order);
        request.getSession().removeAttribute("order");
        return "noPay";
    }

    /**
     * 通过用户id获取当前用户的所有信息
     * @return
     */
    @RequestMapping(value = "/selectByUserId",method = RequestMethod.GET)
    public String selectByUserId(ModelMap modelMap) {
        List<Order> orders = orderService.selectByUserId(1);
        modelMap.addAttribute("orderList",orders);
        System.out.println("========2=========="+orders);
        String msg = (String) modelMap.get("msg");
        System.out.println("123456"+msg);
        return "order";
    }

    /**
     * 进入订单信息进行修改
     * @param id
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestParam("orderId") Integer id, ModelMap modelMap) {
        Order order= orderService.selectId(id);
        modelMap.addAttribute("order",order);
        return "order1";
    }

    /**
     * 查看订单详情页
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/selectByOrderId",method = RequestMethod.POST)
    public String selectByOrderId(@RequestParam("orderId") Integer id,ModelMap modelMap){
        Order order = orderService.selectId(id);
        System.out.println("======3======="+order);
        modelMap.addAttribute("order",order);
        return "selectByOrderId";
    }


    /**
     * 获取修改订单信息
     * @param order
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/toUpdate",method = RequestMethod.POST)
    public String toUpdate(Order order,ModelMap modelMap){
        boolean flag = orderService.update(order);
        if (flag){
            modelMap.addAttribute("msg","<font color='green'>修改成功</font>");
            List<Order> orders = orderService.selectByUserId(1);
            modelMap.addAttribute("orderList",orders);
            return "order";
        }
        modelMap.addAttribute("msg","<font color='red'>修改失败</font>");
        List<Order> orders = orderService.selectByUserId(1);
        modelMap.addAttribute("orderList",orders);
       return "order";
    }

    /**
     * 删除单个订单
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(@RequestParam("orderId") int id,@RequestParam("userId") int userId,ModelMap modelMap){
        orderService.deleteByFlag(id);
        return "redirect:/order/selectByUserId";
    }

    /**
     *  已完成订单
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/success",method = RequestMethod.GET)
    public String success(@RequestParam("orderId") int id,ModelMap modelMap){
        orderService.success(id);
        return "redirect:/order/selectByUserId";
    }

    /**
     * 已失效订单
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/loser",method = RequestMethod.GET)
    public String loser(@RequestParam("orderId")int id,ModelMap modelMap){
        orderService.loser(id);
        return "redirect:/order/selectByUserId";
    }

    /**
     * 预约成功订单
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/successful",method = RequestMethod.GET)
    public String successful(@RequestParam("orderId") int id,ModelMap modelMap){
        orderService.successful(id);
        return "redirect:/order/selectByUserId";
    }

}
