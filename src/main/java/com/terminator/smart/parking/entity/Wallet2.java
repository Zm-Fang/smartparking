package com.terminator.smart.parking.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Wallet2
{
    private List<Wallet> wallet;
    private List<BankCard> bankCard;

    public List<Wallet> getWallet() {
        return wallet;
    }

    public void setWallet(List<Wallet> wallet) {
        this.wallet = wallet;
    }

    public List<BankCard> getBankCard() {
        return bankCard;
    }

    public void setBankCard(List<BankCard> bankCard) {
        this.bankCard = bankCard;
    }
}
