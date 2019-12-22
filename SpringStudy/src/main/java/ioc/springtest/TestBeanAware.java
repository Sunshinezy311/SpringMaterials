package ioc.springtest;

import org.springframework.beans.factory.BeanNameAware;

public class TestBeanAware implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanAwareName: "+name);
    }
}
