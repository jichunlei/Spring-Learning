package cn.jicl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Auther: xianzilei
 * @Date: 2019/7/28 16:47
 * @Description: Calculator切面类
 */
@Aspect
@Component
public class MyCalculatorAspect {

    @Before("execution(public double cn.jicl.service.MyCalculator.*(double,double))")
    public void beforeStart(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("开始执行[" + methodName + "]方法==>入参为：" + Arrays.asList(params));
    }

    @After("execution(public double cn.jicl.service.MyCalculator.*(double,double))")
    public void afterEnd() {
        System.out.println("方法执行结束。");
    }

    @AfterReturning("execution(public double cn.jicl.service.MyCalculator.*(double,double))")
    public void afterReturnning() {
        System.out.println("方法正常返回。");
    }

    @AfterThrowing("execution(public double cn.jicl.service.MyCalculator.*(double,double))")
    public void afterThrowing() {
        System.out.println("方法抛出异常。");
    }

    //    @Around("execution(public double cn.jicl.service.MyCalculator.*(double,double))")
    public void surround() {
        System.out.println("环绕通知。");
    }


}
