package com.terminator.smart.parking.controller;

import com.terminator.smart.parking.entity.Opinion;
import com.terminator.smart.parking.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
*@Description 
*@Author 周智华
*@DateTime 2019/7/25 20:12
*/

@Controller
@RequestMapping("/opinion")
public class OpinionController
{
    @Autowired
    private OpinionService opinionService;
    @RequestMapping(value = "/opinion",method = RequestMethod.GET)
    public String toOpinion()
    {
        return "opinion";
    }

    @RequestMapping(value = "addOpinion",method = RequestMethod.POST)
    public String toAddOpinion(Opinion opinion, ModelMap modelMap)
    {
        System.out.println(opinion);
        opinionService.insertOpinion(opinion);
        modelMap.addAttribute("SubmitSuccess","<font color='green'>意见反馈成功</font>");
        return "opinion";
    }
}
