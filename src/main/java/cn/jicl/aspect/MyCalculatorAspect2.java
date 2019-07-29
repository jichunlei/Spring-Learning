package cn.jicl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/28 16:47
 * @Description: Calculator切面类2
 */
@Component
public class MyCalculatorAspect2 {

    /**
     * @param joinPoint 1
     * @Description: 前置通知
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/29 8:24
     **/
    public void beforeStart(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("【前置通知】>>>开始执行[" + methodName + "]方法==>入参为：" + Arrays.asList(params));
    }

    /**
     * @param joinPoint 1
     * @Description: 后置通知
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/29 8:24
     **/
    public void afterEnd(JoinPoint joinPoint) {
        System.out.println("【后置通知】>>>[" + joinPoint.getSignature().getName() + "]方法执行结束。");
    }

    /**
     * @param joinPoint 1
     * @param result    2
     * @Description: 返回通知
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/29 8:24
     **/
    public void afterReturnning(JoinPoint joinPoint, Object result) {
        System.out.println("【返回通知】>>>[" + joinPoint.getSignature().getName() + "]方法正常返回==>返回结果为：" + result);
    }

    /**
     * @param joinPoint 1
     * @param e         2
     * @Description: 异常通知
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/29 8:24
     **/
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("【异常通知】>>>[" + joinPoint.getSignature().getName() + "]方法抛出异常==>异常信息为：" + e);
    }

    /**
     * @param pjp 1
     * @Description: 环绕通知：Spring最强大的通知（四合一）==>本质就是动态代理
     * @return: java.lang.Object
     * @auther: xianzilei
     * @date: 2019/7/29 8:29
     **/
    public Object surround(ProceedingJoinPoint pjp) {
        //获取方法入参
        Object[] args = pjp.getArgs();
        //获取方法名
        String methodName = pjp.getSignature().getName();
        Object proceed = null;
        try {
            //该方法等同于method.invoke(obj,args)
            System.out.println("【环绕通知】>>>开始执行[" + methodName + "]方法==>入参为：" + Arrays.asList(args));
            proceed = pjp.proceed(args);
            System.out.println("【环绕通知】>>>[" + methodName + "]方法正常返回==>返回结果为：" + proceed);
        } catch (Throwable throwable) {
            System.out.println("【环绕通知】>>>[" + methodName + "]方法抛出异常==>异常信息为：" + throwable);
            //为了能让外界感知异常，需要将异常抛出
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("【环绕通知】>>>[" + methodName + "]方法执行结束。");
        }
        return proceed;
    }


}
