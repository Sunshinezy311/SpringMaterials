package aop.by_2_aspectj_2;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserProxyTest extends TestCase {


    @Test
    public void testAop(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-4-1-Aop.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

}