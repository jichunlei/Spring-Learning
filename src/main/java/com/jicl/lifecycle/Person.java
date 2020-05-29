package com.jicl.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 实体类
 *
 * @author : xianzilei
 * @date : 2020/5/29 08:13
 */
public class Person implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Person.setName()执行...");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Person.setBeanFactory()执行...");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Person.setBeanName()执行...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Person.destroy()执行...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Person.afterPropertiesSet()执行...");
    }

    // 自定义初始化方法
    @PostConstruct
    public void springPostConstruct() {
        System.out.println("Person.@PostConstruct");
    }

    // 自定义销毁方法
    @PreDestroy
    public void springPreDestory() {
        System.out.println("Person.@PreDestory");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Person.finalize()执行");
    }

    //init-method
    public void myInitMethod() {
        System.out.println("Person.myInitMethod()执行");
    }

    //destroy-method
    public void myDestroyMethod() {
        System.out.println("Person.myDestroyMethod()执行");
    }
}
