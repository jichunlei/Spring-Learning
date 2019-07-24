package cn.jicl.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/24 22:30
 * @Description: TODO
 */
public class MyBeanPostProcessoImpl implements BeanPostProcessor {

    /**
     * bean初始化前置操作
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "即将初始化为" + bean);
        return bean;
    }

    /**
     * bean初始化后置操作
     *
     * @param bean
     * @param beanName
     * @return 初始化之后返回的bean对象
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "初始化完成" + bean);
        return bean;
    }
}
