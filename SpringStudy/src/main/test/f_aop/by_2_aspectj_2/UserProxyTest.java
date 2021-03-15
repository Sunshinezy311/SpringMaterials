package f_aop.by_2_aspectj_2;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class UserProxyTest extends TestCase {


    @Test
    public void testAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-4-1-Aop.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    //Spring5中支持的函数式风格的编程
    @Test
    public void testFunctionStyle() {
        //1 创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2 调用context方法对象注册
        context.refresh();
        context.registerBean(User.class, User::new);
        User user=(User)context.getBean("aop.by_2_aspectj_2.User");
        System.out.println(user);

        context.registerBean("user1",User.class, User::new);
        User user1=(User)context.getBean("user1");
        System.out.println(user1);
    }
}