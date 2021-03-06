package com.terminator.smart.parking.controller;

import com.terminator.smart.parking.entity.BankCard;
import com.terminator.smart.parking.entity.User;
import com.terminator.smart.parking.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
*@Description 
*@Author 周智华
*@DateTime 2019/7/24 11:48
*/
@Controller
@RequestMapping("/BankCard")
public class BankCardController
{
    @Autowired
    private BankCardService bankCardService;
    @RequestMapping(value = "/bankCard",method = RequestMethod.GET)
    public String toBankCard()
    {
        return "addBankCard";
    }

    @RequestMapping(value = "/addBankCard",method = RequestMethod.GET)
    public String toAddBankCard(BankCard bankCard, HttpSession session)
    {
        User user = (User) session.getAttribute("USER_LOGIN");
        bankCard.setUserId(user.getUserId());
        bankCard.setUsername(user.getUsername());
        bankCardService.addBankCard(bankCard);
        return "redirect:/wallet/wallet";
    }
}
