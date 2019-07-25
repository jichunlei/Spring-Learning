package cn.jicl.entity.controller;

import cn.jicl.entity.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
