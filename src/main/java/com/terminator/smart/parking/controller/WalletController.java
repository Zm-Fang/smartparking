package com.terminator.smart.parking.controller;

import com.terminator.smart.parking.entity.Wallet;
import com.terminator.smart.parking.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/wallet")
public class WalletController
{
    @Autowired
    private WalletService walletService;
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
    public String toWallet(ModelMap modelMap)
    {
        List<Wallet> wallets = walletService.selectBalance("zs");
        modelMap.addAttribute("wallets",wallets);
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
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value = "/rechargeWallet",method = RequestMethod.GET)
    public String toRechargeWallet(String money,ModelMap modelMap,HttpServletRequest request)
    {
        String username = (String) request.getSession().getAttribute("username");
        walletService.updateWallet("zs",money,1);
        return "forward:wallet.toWallet";
    }

    /**
     *  支付停车费
     * @param money     需要支付的费用
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value = "/payment ",method = RequestMethod.GET)
    public String toPaymentWallet(String money,ModelMap modelMap,HttpServletRequest request)
    {
        String username = (String) request.getSession().getAttribute("username");
        walletService.updateWallet("zs",money,0);
        return "forward:wallet.toWallet";
    }
}
