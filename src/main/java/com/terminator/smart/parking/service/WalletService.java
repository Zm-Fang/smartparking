package com.terminator.smart.parking.service;

import com.terminator.smart.parking.entity.Wallet;
import org.springframework.stereotype.Service;

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
     *  支付或者充值
     * @param wallet    需要支付或者充值的钱包对象
     * @return          受影响行数
     */
    int updateWallet(Wallet wallet);

    /**
     *  查询余额
     * @param user_id   需要查询余额的用户
     * @return          余额
     */
    String selectBalance(String user_id);
}