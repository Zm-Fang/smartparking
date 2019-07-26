package com.terminator.smart.parking.entity;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
*@Description 
*@Author 周智华
*@DateTime 2019/7/23 14:53
*/

@Component
public class Wallet
{
    private BigInteger walletId;
    private Integer userId;
    private Double walletBalance;

    public Wallet() {
    }

    public Wallet(BigInteger walletId, Integer userId, Double walletBalance) {
        this.walletId = walletId;
        this.userId = userId;
        this.walletBalance = walletBalance;
    }

    public BigInteger getWalletId() {
        return walletId;
    }

    public void setWalletId(BigInteger walletId) {
        this.walletId = walletId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletId=" + walletId +
                ", userId='" + userId + '\'' +
                ", walletBalance=" + walletBalance +
                '}';
    }
}
