package com.terminator.smart.parking.service.impl;

import com.terminator.smart.parking.dao.BankCardDao;
import com.terminator.smart.parking.entity.BankCard;
import com.terminator.smart.parking.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
*@Description 
*@Author 周智华
*@DateTime 2019/7/24 11:48
*/
@Service
public class BankCardServiceImpl implements BankCardService
{
    @Autowired
    private BankCardDao bankCardDao;
    @Override
    public int addBankCard(BankCard bankCard)
    {
        return bankCardDao.addBankCard(bankCard);
    }

    @Override
    public int deleteBankCard(Integer id)
    {
        return bankCardDao.deleteBankCard(id);
    }

    @Override
    public List<BankCard> getBankCardById(Integer id)
    {
        return bankCardDao.getBankCardById(id);
    }
}
