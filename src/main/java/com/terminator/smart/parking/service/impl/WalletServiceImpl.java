package com.terminator.smart.parking.service.impl;

import com.terminator.smart.parking.dao.WalletDao;
import com.terminator.smart.parking.entity.Wallet;
import com.terminator.smart.parking.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*@Description 
*@Author 周智华
*@DateTime 2019/7/23 14:58
*/
@Service
public class WalletServiceImpl implements WalletService
{
    @Autowired
    private WalletDao walletDao;
    @Override
    public int insertWallet(Wallet wallet) {
        return walletDao.insertWallet(wallet);
    }

    @Override
    public int updateWallet(Wallet wallet) {
        return walletDao.updateWallet(wallet);
    }

    @Override
    public String selectBalance(String user_id) {
        return walletDao.selectBalance(user_id);
    }
}
