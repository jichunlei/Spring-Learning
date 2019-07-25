package cn.jicl.bean;

import cn.jicl.entity.Car;
import cn.jicl.entity.Person;
import cn.jicl.entity.Student;
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
     * @Description: 根据bean的id从IOC容器中获取bean对象
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
}
