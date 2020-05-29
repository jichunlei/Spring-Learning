package com.jicl.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean生命周期测试类
 *
 * @author : xianzilei
 * @date : 2020/5/29 08:27
 */
public class SpringBeanLifecycleApplication {
    public static void main(String[] args) {
        // 为面试而准备的Bean生命周期加载过程
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
        Person person = (Person) context.getBean("person");
        System.out.println("Person name = " + person.getName());
        ((ClassPathXmlApplicationContext) context).destroy();

    }
}
