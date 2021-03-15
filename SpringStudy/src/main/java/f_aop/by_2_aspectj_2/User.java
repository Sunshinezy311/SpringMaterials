package f_aop.by_2_aspectj_2;

import org.springframework.stereotype.Component;

@Component
public class User {
    public void add(){
        System.out.println("add...");
    }
}
