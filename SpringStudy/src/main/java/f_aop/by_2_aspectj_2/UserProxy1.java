package f_aop.by_2_aspectj_2;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//对于同一个方法的切入点，如果有多个增强类对其进行操作，可以设置优先级
@Order(2000)
public class UserProxy1 {
    //对于相同的切入点，可以提取公共变量
    @Pointcut(value = "execution(* aop.by_2_aspectj_2.User.add(..))")
    public void pointDemo(){

    }

    //记住一定要在域的通配符后面用空格隔开！
    @Before(value = "pointDemo()")
    public void before() {
        System.out.println("UserProxy1 before...");
    }


}
