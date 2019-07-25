package com.terminator.smart.parking.service.impl;

import com.terminator.smart.parking.dao.WalletDao;
import com.terminator.smart.parking.entity.Wallet;
import com.terminator.smart.parking.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    private Wallet wallet;
    @Override
    public int insertWallet(Wallet wallet) {
        return walletDao.insertWallet(wallet);
    }

    @Override
    public int updateWallet(String username, String money, int i)
    {
        List<Wallet> wallets = walletDao.selectBalance(username);
        wallet.setUserId(username);
        if (i > 0)
        {
            wallet.setWalletBalance(wallets.get(0).getWalletBalance()+Double.parseDouble(money));
            return walletDao.updateWallet(wallet);
        }
        else
        {
            wallet.setWalletBalance(wallets.get(0).getWalletBalance()-Double.parseDouble(money));
            return walletDao.updateWallet(wallet);
        }
    }


    @Override
    public List<Wallet> selectBalance(String userId)
    {
        List<Wallet> wallets = walletDao.selectBalance(userId);

        return wallets;
    }
}
