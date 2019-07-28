package cn.jicl.dao;

import cn.jicl.entity.Car;
import org.springframework.stereotype.Repository;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/25 22:00
 * @Description: TODO
 */
@Repository
public class CarDao extends BaseDao<Car> {

    @Override
    public Car get() {
        return new Car();
    }

    @Override
    public void add(Car car) {
        System.out.println("制造汽车");
    }
}
