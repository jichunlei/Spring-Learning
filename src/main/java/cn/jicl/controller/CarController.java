package cn.jicl.controller;

import cn.jicl.dao.CarDao;
import cn.jicl.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/25 22:00
 * @Description: TODO
 */
@Controller
public class CarController {

    @Autowired
    private CarService carService;

    public void addCar() {
        carService.addCar();
    }

    /**
     * @param carDao     1
     * @param carService 2
     * @Description: TODO
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/26 8:04
     **/
    @Autowired
    public void test(CarDao carDao, @Qualifier("carService") CarService carService) {
        /**
         * 当@Autowired在方法上，会在启动容器的时候调用该方法，并且自动装配每一个入参，装入规则同样
         **/
        System.out.println("注入carDao和carService：" + carDao + "==>" + carService);
    }
}
