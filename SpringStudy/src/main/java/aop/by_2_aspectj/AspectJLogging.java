package aop.by_2_aspectj;

import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJLogging {
    /**
     * Following is the definition for a pointcut to select
     * all the methods available. So advice will be called
     * for all the methods.
     */
    @Pointcut("execution(* aop.by_2_aspectj.*.*(..))")
    private void aspectJSelectAll() {
        System.out.println(
                "这里是打断点的地方，该函数类似xml中配置了：" +
                        "“<aop:pointcut id=\"selectAll\" expression=\"execution(* aop.xmlbased.*.*(..))\"/>”");
    }

    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    @Before("aspectJSelectAll()")
    public void beforeAdvice() {
        System.out.println("在执行下面的方法前，会先执行aop:before切片里的内容");
    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution.
     */
    @After("aspectJSelectAll()")
    public void afterAdvice() {
        System.out.println("在执行上面的方法后，会再执行aop:after切片里的内容");
    }

    /**
     * This is the method which I would like to execute
     * when any method returns.
     */
    @AfterReturning(pointcut = "aspectJSelectAll()", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        System.out.println("在上面的方法返回以后，会在aop:after-returning切片里执行后续的内容，例如这里会打印返回结果：" + retVal.toString());
    }

    /**
     * This is the method which I would like to execute
     * if there is an exception raised by any method.
     */
    @AfterThrowing(pointcut = "aspectJSelectAll()", throwing = "ex")
    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("当抛出异常后，会在aop:after-throwing切片里执行后续的内容，例如这里会打印异常的堆栈信息：" + ex.toString());
    }
}
