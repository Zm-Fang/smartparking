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
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
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
        return "first";
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
                          @RequestParam("year")Integer year,
                          @RequestParam("month")Integer month,
                          @RequestParam("date")Integer date,
                          @RequestParam("start_time")String start_time,
                          @RequestParam("end_time")String end_time,
                          HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute("user");
        String createTime=year+"-"+month+"-"+date+" "+start_time;
        String stopTime=year+"-"+month+"-"+date+" "+end_time;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date createTime1=null;
        Date stopTime1=null;
        Date startTime = new Date();
        String s1 = StringUtils.substringBefore(start_time, ":");
        String s2= StringUtils.substringBefore(end_time, ":");
        Double orderPirce=(Integer.parseInt(s2)-Integer.parseInt(s1))*parkingPrice;
        try {
             createTime1 = format.parse(createTime);
             stopTime1=format.parse(stopTime);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Order order = new Order();
        order.setParkingName(parkingName);
        return "timechoose";
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
