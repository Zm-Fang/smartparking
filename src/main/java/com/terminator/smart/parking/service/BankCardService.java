package com.terminator.smart.parking.service;

import com.terminator.smart.parking.entity.BankCard;

import java.util.List;
/**
*@Description 
*@Author 周智华
*@DateTime 2019/7/24 11:46
*/
public interface BankCardService
{
    /**
     *  添加银行卡
     * @param bankCard  需要添加的银行卡的对象
     * @return          受影响行数
     */
    int addBankCard(BankCard bankCard);

    /**
     *  删除银行卡
     * @param id  需要删除银行卡的用户id
     * @return          受影响行数
     */
    int deleteBankCard(Integer id);

    /**
     *  查看银行卡
     * @param id  需要查看银行卡的用户id
     * @return          查询银行卡的用户的数据集合
     */
    List<BankCard> getBankCardById(Integer id);
}
