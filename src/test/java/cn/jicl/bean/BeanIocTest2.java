package cn.jicl.bean;

import cn.jicl.entity.Car;
import cn.jicl.entity.Person;
import cn.jicl.entity.Student;
import cn.jicl.entity.controller.CarController;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/22 08:48
 * @Description:
 */
public class BeanIocTest2 {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config/bean3.xml");


    /**
     * @Description: 使用注解注入bean
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test01() {
        //从IOC中获取bean对象
        Car car1 = (Car) context.getBean("car");
        Car car2 = (Car) context.getBean("car");
        System.out.println(car1 == car2);
    }

    /**
     * @Description: @Autowired注解的自动装配
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test02() {
        //从IOC中获取bean对象
        CarController carController = context.getBean(CarController.class);
        carController.addCar();
        String[] names = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
