package unused.bean_test.bean_context;

import org.springframework.stereotype.Component;

@Component("beanAnnotation")
public class BeanAnnotation {
    public void say(String arg) {
        System.out.println("BeanAnnotation:" + arg);
    }
}
