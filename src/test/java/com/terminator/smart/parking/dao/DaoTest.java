package com.terminator.smart.parking.dao;


import com.terminator.smart.parking.entity.Parking;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration("src/main/resources")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml",
        "classpath:spring-context-druid.xml",
        "classpath:spring-context-mybatis.xml"})
public class DaoTest {
    @Autowired
    private ParkingDao parkingDao;
    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     */
    @Test
    public void testDelete(){
        List<Parking> list = parkingDao.search("千");
        System.out.println(list);
        System.out.println(1);
        //Parking parking = parkingDao.selectByParkingId(1);
       // System.out.println(parking);
        System.out.println("=======");
        parkingDao.selectByParkingSite("越秀区");
    }
}
