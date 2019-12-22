package bean_test.spring_support_jsr;

import org.springframework.stereotype.Repository;

@Repository
public class JsrDAO {
    public void save(){
        System.out.println("JsrDAO invoked!");
    }
}

