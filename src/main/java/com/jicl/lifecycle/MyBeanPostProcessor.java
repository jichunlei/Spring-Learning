package com.jicl.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 自定义BeanPostProcessor
 *
 * @author : xianzilei
 * @date : 2020/5/29 08:19
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 容器加载的时候会加载一些其他的bean，会调用初始化前和初始化后方法
    // 这次只关注Person(bean)的生命周期
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization()执行...");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            System.out.println("MyBeanPostProcessor.postProcessAfterInitialization()执行...");
        }
        return bean;
    }
}
