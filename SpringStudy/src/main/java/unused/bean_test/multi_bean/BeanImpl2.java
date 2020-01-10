package unused.bean_test.multi_bean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 1)
@Component
public class BeanImpl2 implements BeanInterface {
}
