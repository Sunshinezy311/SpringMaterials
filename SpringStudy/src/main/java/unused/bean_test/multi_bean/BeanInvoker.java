package unused.bean_test.multi_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeanInvoker {

    @Autowired
    private List<BeanInterface> list;

    @Autowired
    public BeanInvoker(List<BeanInterface> list) {
        this.list = list;
    }

    public void say() {
        if (list != null) {
            for (BeanInterface bean : list) {
                System.out.println(bean.getClass().getName());
            }
        } else {
            System.out.println("the list is null!");
        }
    }

    @Autowired
    //使用Qualifier注解可以缩小范围，对于多个实现接口尤为有效
    @Qualifier("beanImpl1")
    private BeanInterface beanInterface;

    public void saybeanImpl1(){
        if (list != null) {
                System.out.println(beanInterface.getClass().getName());
        } else {
            System.out.println("the list is null!");
        }
    }


}
