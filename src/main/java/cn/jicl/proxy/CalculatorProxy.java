package cn.jicl.proxy;

import cn.jicl.service.Calculator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/28 09:56
 * @Description: TODO
 */
public class CalculatorProxy {

    /**
     * 获取对象的代理对象
     *
     * @param calculator 被代理对象
     * @return 代理对象
     */
    public static Calculator getProxy(Calculator calculator) {
        Object proxyInstance = Proxy.newProxyInstance(calculator.getClass().getClassLoader(),
                calculator.getClass().getInterfaces(),
                /**
                 * proxy:指被代理的对象（一般不动）
                 * method:被执行的方法
                 * args:被执行的方法的参数
                 */
                (proxy, method, args) -> {
                    Object result = null;
                    try {
                        System.out.println("方法[" + method.getName() + "]开始执行==>请求参数为" + Arrays.asList(args));
                        result = method.invoke(calculator, args);
                        System.out.println("方法[" + method.getName() + "]执行完毕==>执行结果为" + Arrays.asList(result));
                    } catch (Exception e) {
                        System.out.println("方法[" + method.getName() + "]执行出错==>错误信息为" + e);
                    } finally {
                        System.out.println("方法最终执行完成。");
                    }
                    return result;
                });
        return (Calculator) proxyInstance;
    }

}
