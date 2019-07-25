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
    private BigInteger wallet_id;
    private String user_id;
    private Double wallet_balance;

    public Wallet() {
    }

    public Wallet(BigInteger wallet_id, String user_id, Double wallet_balance) {
        this.wallet_id = wallet_id;
        this.user_id = user_id;
        this.wallet_balance = wallet_balance;
    }

    public BigInteger getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(BigInteger wallet_id) {
        this.wallet_id = wallet_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Double getWallet_balance() {
        return wallet_balance;
    }

    public void setWallet_balance(Double wallet_balance) {
        this.wallet_balance = wallet_balance;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "wallet_id=" + wallet_id +
                ", user_id='" + user_id + '\'' +
                ", wallet_balance=" + wallet_balance +
                '}';
    }
}
