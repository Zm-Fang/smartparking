package com.terminator.smart.parking.dao;

import com.terminator.smart.parking.entity.Parking;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description 停车场 dao 层，用于数据库交互
 * @Author 方泽谋
 * @DateTime 2019/7/22 22:01
 */
@Repository
public interface ParkingDao {

    /**
     * @Description 查找所有停车场
     * @Author 方泽谋
     * @return 停车场集合
     * @DateTime 2019/7/22 22:02
     */
    List<Parking> selectAll();

    Parking selectParkingByParkingId(int id);

    /**
     * @Description 添加一个停车场信息
     * @param parking 停车场对象
     * @return 影响行数
     * @Author 方泽谋
     * @DateTime 2019/7/23 0:12
     */
    int insertParking(Parking parking);

    /**
     * @Description 通过停车场 id 删除停车场
     * @param id parking_id
     * @return
     * @Author 方泽谋
     * @DateTime 2019/7/23 0:20
     */
    int deleteParkingByParkingId(int id);

    /**
     * @Description 通过停车场 id 修改停车场信息
     * @param parking 停车场对象
     * @return 影响行数
     * @Author 方泽谋
     * @DateTime 2019/7/23 0:27
     */
    int updateParkingByParkingId(Parking parking);

    /**
    *@Description   通过模糊查询停车场名  查看停车场信息
    *@Author 刘新全
    *@DateTime 2019/7/23 17:04
    */
    List<Parking> search(@RequestParam("parkingName") String parkingName);


    /**
    *@Description  通过id查询停车场信息
    *@Author 刘新全
    *@DateTime 2019/7/23 17:48
    */
    List<Parking> selectByParkingId(Integer parkingId);

    /**
    *@Description  通过地点查询停车场信息
    *@Author 刘新全
    *@DateTime 2019/7/23 17:49
    */
    List<Parking>  selectByParkingSite(String parkingSite);
}
