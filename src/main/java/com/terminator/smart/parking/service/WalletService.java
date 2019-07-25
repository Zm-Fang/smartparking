package com.terminator.smart.parking.service;

import com.terminator.smart.parking.entity.Wallet;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@Description 
*@Author 周智华
*@DateTime 2019/7/23 14:57
*/
public interface WalletService
{
    /**
     *  初始化钱包
     * @param wallet    需要初始化的钱包对象
     * @return          受影响行数
     */
    int insertWallet(Wallet wallet);

    /**
     *  充值或者支付
     * @param username  需要充值或支付的用户
     * @param money     需要充值或者支付的金额
     * @param i         判断充值还是支付，1位充值，0位支付
     * @return          受影响行数
     */
    int updateWallet(String username,String money,int i);

    /**
     *  查询余额
     * @param userId   需要查询余额的用户
     * @return          余额
     */
   List<Wallet> selectBalance(String userId);
}
