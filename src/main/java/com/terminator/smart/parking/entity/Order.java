package com.terminator.smart.parking.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private int userId;
    private String username;
    private int orderId;
    private String licenseNumber;
    private String parkingName;
    private Date createTime;
    private Date stopTime;
    private String orderStatus;
    private int flag;
    private int isRemove;

    public Order() {
    }

    public Order(int userId, String username, int orderId, String licenseNumber, String parkingName,
                 Date createTime, Date stopTime, String orderStatus, int flag, int isRemove) {
        this.userId = userId;
        this.username = username;
        this.orderId = orderId;
        this.licenseNumber = licenseNumber;
        this.parkingName = parkingName;
        this.createTime = createTime;
        this.stopTime = stopTime;
        this.orderStatus = orderStatus;
        this.flag = flag;
        this.isRemove = isRemove;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getIsRemove() {
        return isRemove;
    }

    public void setIsRemove(int isRemove) {
        this.isRemove = isRemove;
    }

    @Override
    public String toString() {
        return "Order{" + "userId=" + userId + ", username='" + username + '\'' + ", " +
                "orderId=" + orderId + ", licenseNumber='" + licenseNumber + '\'' + "," +
                " parkingName='" + parkingName + '\'' + ", createTime=" + createTime + ", " +
                "stopTime=" + stopTime + ", orderStatus='" + orderStatus + '\'' + ", flag=" + flag + "," +
                " isRemove=" + isRemove + '}';

    }
}