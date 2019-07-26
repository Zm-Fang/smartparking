package com.terminator.smart.parking.controller;

import com.terminator.smart.parking.entity.BankCard;
import com.terminator.smart.parking.entity.User;
import com.terminator.smart.parking.entity.Wallet;
import com.terminator.smart.parking.entity.Wallet2;
import com.terminator.smart.parking.service.BankCardService;
import com.terminator.smart.parking.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/wallet")
public class WalletController
{
    @Autowired
    private WalletService walletService;
    @Autowired
    private BankCardService bankCardService;
    @Autowired
    private Wallet2 wallet2;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String toIndex()
    {
        return "index";
    }

    /**
     * 显示余额
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/wallet",method = RequestMethod.GET)
    public String toWallet(ModelMap modelMap, HttpSession session)
    {
        User user = (User) session.getAttribute("USER_LOGIN");
        List<Wallet> wallets = walletService.selectBalance(user.getUserId());
        List<BankCard> bankCard = bankCardService.getBankCardById(user.getUserId());
        wallet2.setWallet(wallets);
        wallet2.setBankCard(bankCard);
        modelMap.addAttribute("wallet2",wallet2);
        return "wallet";
    }

    /**
     *  跳转充值页面
     * @return  充值页面
     */
    @RequestMapping(value = "/recharge",method = RequestMethod.GET)
    public String toRecharge()
    {
        return "recharge";
    }

    /**
     *  充值
     * @param money     需要充值的金额
     * @param session
     * @return
     */
    @RequestMapping(value = "/rechargeWallet",method = RequestMethod.GET)
    public String toRechargeWallet(Double money,HttpSession session)
    {
        System.out.println(money);
        User user = (User) session.getAttribute("USER_LOGIN");
        System.out.println(user);
        walletService.updateWallet(user.getUserId(),money,1);
        return "forward:wallet.toWallet";
    }

    /**
     *  支付停车费
     * @param money     需要支付的费用
     * @return
     */
    @RequestMapping(value = "/payment",method = RequestMethod.POST)
    public String toPaymentWallet(Double money,int orderId,HttpSession session,ModelMap modelMap)
    {
        User user = (User) session.getAttribute("USER_LOGIN");
        int i = walletService.updateWallet(user.getUserId(), money, 0);
        if (i == 2)
        {
            return "error";

        }
        return "redirect:/order/successful?orderId="+orderId;
    }
}
