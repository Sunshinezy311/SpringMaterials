package f_aop.by_2_aspectj_2;

import org.springframework.stereotype.Component;


// 实现AOP编程有两种方式，一种是有接口的，一种是无接口的
// 有接口的动态代理，Spring创建一个类对用户需要增强的 接口实现类 做个代理模式。Spring创建的类和接口实现类都必须实现同一个接口，其相当于增强了接口实现类
// 没有接口的动态代理，Spring同样创建一个类继承用户需要增强的类，
// 详解见：https://blog.csdn.net/weixin_45496190/article/details/107082732 

@Component
public class User {
    public void add(){
        System.out.println("add...");
    }
}
