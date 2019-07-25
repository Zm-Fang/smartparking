package com.terminator.smart.parking.controller;


import com.terminator.smart.parking.entity.Order;
import com.terminator.smart.parking.entity.Parking;
import com.terminator.smart.parking.entity.User;
import com.terminator.smart.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * parking控制层
 */
@Controller
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/first",method = RequestMethod.GET)
    public String first(){
        return "index";
    }

    /**
     * 搜索页面
     * @return
     */
    @RequestMapping("index2")
    public String index2(ModelMap map){
        List<Parking> list = parkingService.selectAll();
        map.addAttribute("list",list);
        return "parkingList";
    }

    /**
     * 根据id获取停车场信息
     * @return
     */
    @RequestMapping(value = "/getParkingById")
    public String getParkingById(Integer parkingId, ModelMap map, HttpServletRequest request){
        List<Parking> list = parkingService.selectByParkingId(parkingId);
        map.addAttribute("list",list);
        return "parking";
    }



    /**
     * 点击预订功能
     * @return
     */
    @RequestMapping(value = "/reserve",method = RequestMethod.POST)
    public String reserve(@RequestParam("parkingPrice")double parkingPrice,
                          @RequestParam("parkingName")String parkingName,
                          @RequestParam("data-date-format")String data_date_format,
                          @RequestParam("start_time")Integer start_time,
                          @RequestParam("end_time")Integer end_time,
                          HttpServletRequest request)
    {
       // User user = (User) request.getSession().getAttribute("user");
        User user = new User();
        user.setUserId(1);
        user.setUsername("quange");
        user.setLicenseNumber("1234465465");
        String createTime=data_date_format+" "+start_time+":00:00";
        String stopTime=data_date_format+" "+end_time+":00:00";

        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String startTime = format.format(date1);


        Double orderPrice=((end_time)-(start_time))*parkingPrice;

        Order order = new Order();
        order.setUserId(user.getUserId());
        order.setUsername(user.getUsername());
        order.setLicenseNumber(user.getLicenseNumber());
        order.setParkingName(parkingName);
        order.setStartTime(startTime);
        order.setCreateTime(createTime);
        order.setStopTime(stopTime);
        order.setOrderStatus("未付款");
        order.setOrderPrice(orderPrice);
        System.out.println("----------"+order);
        request.getSession().setAttribute("order",order);
        return "forward:/order/insert";
    }


    /**
     * 模糊查询停车场名
     * @param parkingName
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String search(@RequestParam("parkingName")String parkingName,ModelMap modelMap){
        List<Parking> list = parkingService.search(parkingName);
        modelMap.addAttribute("list", list);
        return "tables";
    }

    /**
     * 根据地点查询停车场
     * @return
     */
    @RequestMapping(value = "/getParkingByparkingSite",method = RequestMethod.GET)
    public String getParkingByparkingSite(@RequestParam("parkingSite")String parkingSite,ModelMap modelMap){
        List<Parking> list = parkingService.selectByParkingSite(parkingSite);
        modelMap.addAttribute("list", Arrays.asList(list));
        return "tables";
    }

}
