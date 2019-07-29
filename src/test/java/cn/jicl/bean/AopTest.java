package cn.jicl.bean;

import cn.jicl.proxy.CalculatorProxy;
import cn.jicl.service.Calculator;
import cn.jicl.service.MyCalculator;
import cn.jicl.service.impl.CalculatorImpl;
import org.aspectj.lang.annotation.Around;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/28 10:22
 * @Description: AOP测试类
 */
@ContextConfiguration(locations = "classpath:config/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AopTest {
    //要是使用aop，必须注入接口，不能是接口实现类，否则报错
    //如果没有接口，那就写本类类型
    @Autowired
    private Calculator calculator;

    @Autowired
    private MyCalculator myCalculator;

    /**
     * @Description: JDK动态代理（不推荐使用）
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/28 10:42
     **/
    @Test
    public void test01() {
//        Calculator proxy = CalculatorProxy.getProxy(calculator);
//        //代理对象和被代理对象唯一能产生的关联就是实现了同一个接口
//        //返回class com.sun.proxy.$Proxy17（实现了Calculator接口）
//        System.out.println(proxy.getClass());
//        //返回interface cn.jicl.service.Calculator
//        System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));
//        proxy.add(1,2);
//
//        proxy.div(1,1);

    }

    /**
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/28 10:42
     **/
    @Test
    public void test02() {
        //输出class com.sun.proxy.$Proxy24
        //说明容器中保存的组件是目标对象的代理类型
        System.out.println(calculator.getClass());
        calculator.add(2, 5);
    }

    /**
     * @Description: SpringAOP动态代理(被代理对象非接口实现类)
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/28 10:42
     **/
    @Test
    public void test03() {
        //输出cn.jicl.service.MyCalculator$$EnhancerBySpringCGLIB$$a329edbf
        //CGLIB帮我们创建的代理对象-
        System.out.println(myCalculator.getClass());
        myCalculator.add(1, 2);
    }

    /**
     * @Description: SpringAOP环绕通知
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/28 10:42
     **/
    @Test
    public void test04() {
        double result = calculator.mul(2, 7);
        System.out.println(result);
    }

    /**
     * @Description: SpringAOP环绕通知
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/28 10:42
     **/
    @Test
    public void test05() {
        double result = myCalculator.sub(7, 3);
        System.out.println(result);
    }
}
