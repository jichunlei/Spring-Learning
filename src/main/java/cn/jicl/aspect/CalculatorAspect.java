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
 * @Description: Calculator切面类
 */
@Aspect
@Component
public class CalculatorAspect {

    /**
     * 1.通配符
     *  1）*：
     *  a.匹配一个或多个字符：execution(public double cn.jicl.service.impl.CalculatorImpl.a*d(double,double))
     *  b.匹配任意一个参数：execution(public double cn.jicl.service.impl.CalculatorImpl.add(double,*))
     *  c.匹配任意单层路径：execution(public double cn.jicl.service.*.CalculatorImpl.a*d(double,double))
     *  2)..:
     *   a.配置任意参数：execution(public double cn.jicl.service.impl.CalculatorImpl.add(..))
     *   b.配置任意多层路径：execution(public double cn.jicl.service..CalculatorImpl.a*d(double,double))
     * 注意：
     *  1）访问权限符不能用*来匹配(访问权限符可不写)
     *  2）最模糊匹配：execution(* *(..)):一般不使用
     *  3）切入点表达式支持&&(与)、||(或)、!(非)这三种符号
     *
     *
     * 2.通知方法的执行顺序
     * try {
     *  @before:前置通知
     *  method.invoke(...);
     *  @AfterReturning：返回通知
     *  } catch (Exception e) {
     *  @AfterThrowing：异常通知
     *  } finally {
     *  @After：后置通知
     *  }
     *  1)正常执行：@before-->@After-->@AfterReturning
     *  2)异常执行：@before-->@After-->@AfterThrowing
     *
     * 3.JoinPoint:提供访问当前被通知方法的目标对象、代理对象、方法参数等数据
     *
     * 4.Spring对通知方法要求不高，唯一要求就参数需要写对。
     * 自定义的参数一定要告知Spring
     *
     * 5.抽取
     *
     **/

    /**
     * @Description: 抽取公共的切入点表达式
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/29 8:23
     **/
    @Pointcut("execution(public double cn.jicl.service.impl.CalculatorImpl.add(double,double))")
    public void commonPointcutAdd() {
    }
    //固定写法：execution([访问权限符] 返回值类型 方法全类名(参数...))
    @Pointcut("execution(public double cn.jicl.service.impl.CalculatorImpl.mul(double,double))")
    public void commonPointcutmul() {
    }


    /**
     * @param joinPoint 1
     * @Description: 前置通知
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/29 8:24
     **/
    @Before("commonPointcutAdd()")
    public void beforeStart(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("开始执行[" + methodName + "]方法==>入参为：" + Arrays.asList(params));
    }

    /**
     * @param joinPoint 1
     * @Description: 后置通知
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/29 8:24
     **/
    @After("commonPointcutAdd()")
    public void afterEnd(JoinPoint joinPoint) {
        System.out.println("[" + joinPoint.getSignature().getName() + "]方法执行结束。");
    }

    /**
     * @param joinPoint 1
     * @param result    2
     * @Description: 返回通知
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/29 8:24
     **/
    @AfterReturning(value = "execution(public double cn.jicl.service.impl.CalculatorImpl.add(double,double))"
            , returning = "result")
    public void afterReturnning(JoinPoint joinPoint, Object result) {
        System.out.println("[" + joinPoint.getSignature().getName() + "]方法正常返回==>返回结果为：" + result);
    }

    /**
     * @param joinPoint 1
     * @param e         2
     * @Description: 异常通知
     * @return: void
     * @auther: xianzilei
     * @date: 2019/7/29 8:24
     **/
    @AfterThrowing(value = "execution(public double cn.jicl.service.impl.CalculatorImpl.add(double,double))"
            , throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("[" + joinPoint.getSignature().getName() + "]方法抛出异常==>异常信息为：" + e);
    }

    /**
     * @param pjp 1
     * @Description: 环绕通知：Spring最强大的通知（四合一）==>本质就是动态代理
     * @return: java.lang.Object
     * @auther: xianzilei
     * @date: 2019/7/29 8:29
     **/
    @Around("commonPointcutmul()")
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
            System.out.println("[" + methodName + "]方法抛出异常==>异常信息为：" + throwable);
            //为了能让外界感知异常，需要将异常抛出
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("【环绕通知】>>>[" + methodName + "]方法执行结束。");
        }
        return proceed;
        //环绕通知比其他的普通通知先执行
    }


}
