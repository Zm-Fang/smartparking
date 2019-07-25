package com.terminator.smart.parking.service.impl;

import com.terminator.smart.parking.dao.ParkingDao;
import com.terminator.smart.parking.entity.Parking;
import com.terminator.smart.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 停车场 Service 接口实现类，实现具体的业务逻辑的方法
 * @Author 方泽谋
 * @DateTime 2019/7/22 23:58
 */
@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingDao parkingDao;

    @Override
    public List<Parking> selectAll() {
        return parkingDao.selectAll();
    }

    @Override
    public Parking selectParkingByParkingId(int id) {
        return parkingDao.selectParkingByParkingId(id);
    }

    @Override
    public int insertParking(Parking parking) {
        return parkingDao.insertParking(parking);
    }

    @Override
    public int deleteParkingByParkingId(int id) {
        return parkingDao.deleteParkingByParkingId(id);
    }

    @Override
    public int updateParkingByParkingId(Parking parking) {
        return parkingDao.updateParkingByParkingId(parking);
    }
}
