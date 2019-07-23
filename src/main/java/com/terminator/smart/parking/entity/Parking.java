package com.terminator.smart.parking.entity;

/**
*@Description 停车场实体类
*@Author 方泽谋
*@DateTime 2019/7/22 21:51
*/
public class Parking {
    private int parkingId;
    private String parkingName;
    private double parkingPrice;
    private String parkingSite;
    private int parkingTotal;
    private int parkingUsable;
    private int parkingFlag;

    public Parking() {
    }

    public Parking(int parkingId, String parkingName, double parkingPrice,
                   String parkingSite, int parkingTotal, int parkingUsable,
                   int parkingFlag) {
        this.parkingId = parkingId;
        this.parkingName = parkingName;
        this.parkingPrice = parkingPrice;
        this.parkingSite = parkingSite;
        this.parkingTotal = parkingTotal;
        this.parkingUsable = parkingUsable;
        this.parkingFlag = parkingFlag;
    }

    public int getParkingId() {
        return parkingId;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public double getParkingPrice() {
        return parkingPrice;
    }

    public void setParkingPrice(double parkingPrice) {
        this.parkingPrice = parkingPrice;
    }

    public String getParkingSite() {
        return parkingSite;
    }

    public void setParkingSite(String parkingSite) {
        this.parkingSite = parkingSite;
    }

    public int getParkingTotal() {
        return parkingTotal;
    }

    public void setParkingTotal(int parkingTotal) {
        this.parkingTotal = parkingTotal;
    }

    public int getParkingUsable() {
        return parkingUsable;
    }

    public void setParkingUsable(int parkingUsable) {
        this.parkingUsable = parkingUsable;
    }

    public int getParkingFlag() {
        return parkingFlag;
    }

    public void setParkingFlag(int parkingFlag) {
        this.parkingFlag = parkingFlag;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingId=" + parkingId +
                ", parkingName='" + parkingName + '\'' +
                ", parkingPrice=" + parkingPrice +
                ", parkingSite='" + parkingSite + '\'' +
                ", parkingTotal=" + parkingTotal +
                ", parkingUsable=" + parkingUsable +
                ", parkingFlag=" + parkingFlag +
                '}';
    }
}
