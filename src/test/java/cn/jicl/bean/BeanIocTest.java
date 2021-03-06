package cn.jicl.bean;

import cn.jicl.entity.Person;
import cn.jicl.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/22 08:48
 * @Description:
 */
public class BeanIocTest {
    /**
     * src：源码包开始路径，类路径的开始（所有的源码包中的东西都会合并到该目录下）
     * Java项目：/bin/
     * web项目：/WEB-INF/classes/
     **/

    //ApplicationContext（IOC容器）
    //类路径下的配置文件（推荐使用）
    //容器创建的时候就已经创建了对象
    //IOC容器在创建对象的时候会使用对象的set方法为这个对象的属性赋值
    //Javabean的属性名由set、get方法决定（即方法名去除set或get然后首字母小写）
    //ApplicationContext context = new ClassPathXmlApplicationContext("config/bean.xml");
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config/bean.xml");
    //文件路径下（不推荐）
    //ApplicationContext context=new FileSystemXmlApplicationContext("D:\\IDEA\\GitRepositories\\SpringDemo\\src\\main\\resources\\config\\bean.xml");


    /**
     * @Description: 根据bean的id从IOC容器中获取bean对象
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test01() {
        //从IOC中获取bean对象
        Person person1 = (Person) context.getBean("person");
        Person person2 = (Person) context.getBean("person");
        //容器如果没有这个bean，调用ioc容器的getBean方法会抛异常：NoSuchBeanDefinitionException
        //Person person01 = (Person) context.getBean("person01");
        //同一个组件在容器中只有一个实例
        System.out.println(person1 == person2);
    }

    /**
     * @Description: 根据bean的类名从IOC容器中获取bean对象
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test02() {
        //从IOC中获取bean对象
        Person person = context.getBean(Person.class);
        //如果IOC中有两个person对象（id不同，调用genBean方法会抛异常：NoUniqueBeanDefinitionException）
        System.out.println(person);
    }

    /**
     * @Description: 根据bean的id和类名从IOC容器中获取bean对象
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test03() {
        //从IOC中获取bean对象
        Person person = context.getBean("person", Person.class);
        //即使IOC中有两个person对象（id不同），也不会报错
        System.out.println(person);
    }

    /**
     * @Description: 配置调用对象的有参构造器进行赋值
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test04() {
        //从IOC中获取bean对象
        Person person = context.getBean("person3", Person.class);
        System.out.println(person);
    }

    /**
     * @Description: 配置调用对象的有参构造器进行赋值（xml中不指定name）
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test05() {
        //从IOC中获取bean对象
        Person person = context.getBean("person4", Person.class);
        System.out.println(person);
    }

    /**
     * @Description: 使用p标签注入值
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test06() {
        //从IOC中获取bean对象
        Person person = context.getBean("person5", Person.class);
        System.out.println(person);
    }

    /**
     * @Description: 复杂属性的注入
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test07() {
        //从IOC中获取bean对象
        Person person = context.getBean("person6", Person.class);
        System.out.println(person);
        Person person7 = context.getBean("person7", Person.class);
        System.out.println(person7);
        Map map = context.getBean("myMap", Map.class);
        System.out.println(map);
    }

    /**
     * @Description: 使用配置信息的继承
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test08() {
        //从IOC中获取bean对象
        Person person = context.getBean("person8", Person.class);
        System.out.println(person);
    }

    /**
     * @Description: 创建抽象bean模板
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test09() {
        //从IOC中获取bean对象
        Person person = context.getBean("person9", Person.class);
        System.out.println(person);
        //如果ioc调用getBean方法获取抽象bean模板，会抛异常：BeanIsAbstractException
        //Person abstractPerson = context.getBean("abstractPerson", Person.class);
    }

    /**
     * @Description: 配置bean的作用域
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test10() {
        //从IOC中获取bean对象
        Person person = context.getBean("person10", Person.class);
        Person person2 = context.getBean("person10", Person.class);
        System.out.println(person == person2);
    }

    /**
     * @Description: 使用静态工厂模式创建对象
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test11() {
        //从IOC中获取bean对象
        Person person = context.getBean("person11", Person.class);
        System.out.println(person);
    }

    /**
     * @Description: 使用实例工厂模式创建对象
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test12() {
        //从IOC中获取bean对象
        Person person = context.getBean("person12", Person.class);
        System.out.println(person);
    }

    /**
     * @Description: 使用FactoryBean实现类创建对象
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test13() {
        //从IOC中获取bean对象
        Student student = context.getBean("student1", Student.class);
        System.out.println(student);
    }

    /**
     * @Description: 创建带有生命周期的bean
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test14() {
        context.close();
    }

    /**
     * @Description: 初始化后置处理器
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test15() {
        //从IOC中获取bean对象
        Student student2 = context.getBean("student2", Student.class);
        System.out.println(student2);
    }

    /**
     * @Description: 获取数据库连接池对象
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test16() {
        //从IOC中获取bean对象
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);
    }

    /**
     * @Description: Spring中的关键字username(默认为计算机系统名)
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test17() {
        //从IOC中获取bean对象
        Student student = context.getBean("student3", Student.class);
        System.out.println(student);
    }

    /**
     * @Description: SpEL表达式
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/22 8:59
     **/
    @Test
    public void test18() {
        //从IOC中获取bean对象
        Person person = context.getBean("person13", Person.class);
        System.out.println(person);
    }
}
