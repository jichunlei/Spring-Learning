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
public class CalculatorAspect {

    /**
     * 1.通配符
     * 1）*：
     * a.匹配一个或多个字符：execution(public double cn.jicl.service.impl.CalculatorImpl.a*d(double,double))
     * b.匹配任意一个参数：execution(public double cn.jicl.service.impl.CalculatorImpl.add(double,*))
     * c.匹配任意单层路径：execution(public double cn.jicl.service.*.CalculatorImpl.a*d(double,double))
     * 2)..:
     * a.配置任意参数：execution(public double cn.jicl.service.impl.CalculatorImpl.add(..))
     * b.配置任意多层路径：execution(public double cn.jicl.service..CalculatorImpl.a*d(double,double))
     * 注意：
     * 1）访问权限符不能用*来匹配(访问权限符可不写)
     * 2）最模糊匹配：execution(* *(..)):一般不使用
     * 3）切入点表达式支持&&(与)、||(或)、!(非)这三种符号
     * <p>
     * <p>
     * 2.通知方法的执行顺序
     * try {
     *
     * @before method.invoke(...);
     * @AfterReturning } catch (Exception e) {
     * @AfterThrowing } finally {
     * @After }
     * 1)正常执行：@before-->@After-->@AfterReturning
     * 2)异常执行：@before-->@After-->@AfterThrowing
     * <p>
     * 3.JoinPoint:提供访问当前被通知方法的目标对象、代理对象、方法参数等数据
     **/

    //固定写法：execution([访问权限符] 返回值类型 方法全类名(参数...))
    @Before("execution(public double cn.jicl.service.impl.CalculatorImpl.*(double,double))")
    public void beforeStart(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("开始执行[" + methodName + "]方法==>入参为：" + Arrays.asList(params));
    }

    @After(value = "execution(public double cn.jicl.service.impl.CalculatorImpl.*(double,double))")
    public void afterEnd(JoinPoint joinPoint) {
        System.out.println("[" + joinPoint.getSignature().getName() + "]方法执行结束。");
    }

    @AfterReturning(value = "execution(public double cn.jicl.service.impl.CalculatorImpl.*(double,double))"
            , returning = "result")
    public void afterReturnning(JoinPoint joinPoint, Object result) {
        System.out.println("[" + joinPoint.getSignature().getName() + "]方法正常返回==>返回结果为：" + result);
    }

    @AfterThrowing(value = "execution(public double cn.jicl.service.impl.CalculatorImpl.*(double,double))"
            , throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("[" + joinPoint.getSignature().getName() + "]方法抛出异常==>异常信息为：" + e);
    }

    //    @Around("execution(public double cn.jicl.service.impl.CalculatorImpl.*(double,double))")
    public void surround(JoinPoint joinPoint) {
        System.out.println("环绕通知。");
    }


}
