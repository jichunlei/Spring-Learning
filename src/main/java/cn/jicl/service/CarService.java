package cn.jicl.service;

import cn.jicl.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/25 22:00
 * @Description: TODO
 */
@Service
public class CarService {

    @Autowired
    private CarDao carDao;

    public void addCar() {
        carDao.addCar();
    }
}
