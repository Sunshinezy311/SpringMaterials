package b_ioc.springtest;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Test2Class implements InitializingBean, DisposableBean {
    public void start(){
        System.out.println(TestClass.class+"类已经初始化");
    }
//    public void destory(){
//        System.out.println(TestClass.class+"类已经销毁");
//    }

    public void destroy() {
        System.out.println(TestClass.class + "类已经初始化");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println(TestClass.class + "类已经销毁");
    }
}
