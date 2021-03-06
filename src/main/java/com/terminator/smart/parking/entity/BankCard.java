package com.terminator.smart.parking.entity;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
/**
*@Description 
*@Author 周智华
*@DateTime 2019/7/24 11:25
*/

@Component
public class BankCard
{
    private BigInteger id;
    private Integer userId;
    private String username;
    private String bankName;
    private String CardId;

    public BankCard() {
    }

    public BankCard(BigInteger id, Integer userId, String username, String bankName, String cardId) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.bankName = bankName;
        CardId = cardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        CardId = cardId;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "id=" + id +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", bankName='" + bankName + '\'' +
                ", CardId='" + CardId + '\'' +
                '}';
    }
}
