package com.terminator.smart.parking.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private String startTime;
    private Double orderPrice;
    private int userId;
    private String username;
    private int orderId;
    private String licenseNumber;
    private String parkingName;
    private String createTime;
    private String stopTime;
    private String orderStatus;
    private int flag;
    private int isRemove;

    public Order() {
    }

    public Order(String startTime, Double orderPrice, int userId, String username, int orderId, String licenseNumber, String parkingName, String createTime, String stopTime, String orderStatus, int flag, int isRemove) {
        this.startTime = startTime;
        this.orderPrice = orderPrice;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
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
        return "Order{" + "startTime=" + startTime + ", orderPrice=" + orderPrice + ", " +
                "userId=" + userId + ", username='" + username + '\'' + ", orderId=" +
                orderId + ", licenseNumber='" + licenseNumber + '\'' + ", parkingName='" +
                parkingName + '\'' + ", createTime=" + createTime + ", stopTime=" + stopTime + "," +
                " orderStatus='" + orderStatus + '\'' + ", flag=" + flag + ", isRemove=" + isRemove + '}';
    }
}