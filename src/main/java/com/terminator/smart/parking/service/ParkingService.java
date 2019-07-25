package com.terminator.smart.parking.service;

import com.terminator.smart.parking.entity.Parking;

import java.util.List;

/**
 * @Description 停车场 Service 接口，定义处理消息相关的业务逻辑的方法
 * @Author 方泽谋
 * @DateTime 2019/7/22 23:57
 */
public interface ParkingService {

    List<Parking> selectAll();

    Parking selectParkingByParkingId(int id);

    int insertParking(Parking parking);

    int deleteParkingByParkingId(int id);

    int updateParkingByParkingId(Parking parking);
}
