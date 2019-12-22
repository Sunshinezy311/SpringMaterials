package bean_test.multi_bean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 2)
@Component
public class BeanImpl1 implements BeanInterface {
}
