package cn.jicl.bean;

import cn.jicl.controller.CarController;
import cn.jicl.entity.Car;
import cn.jicl.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @Auther: xianzilei
 * @Date: 2019/7/22 08:48
 * @Description:
 */

/**
 * 使用Spring的单元测试框架
 * 1）@ContextConfiguration：指定spring配置文件的位置
 * 2）@RunWith：指定使用哪种驱动来进行单元测试（默认是junit）
 *
 * @RunWith(SpringJUnit4ClassRunner.class)： 指定使用spring的单元测试驱动来执行加了@Test注解的测试方法
 **/
@ContextConfiguration(locations = "classpath:config/bean3.xml")
@RunWith(SpringJUnit4ClassRunner.class)
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

    @Autowired
    CarController carController;

    /**
     * @Description: 使用Spring的单元测试框架
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test03() {
        System.out.println(carController);
        carController.addCar();
    }
}
