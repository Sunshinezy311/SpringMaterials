import unused.bean_test.bean_context.BeanAnnotation;
import unused.bean_test.multi_bean.BeanInvoker;
import b_ioc.springtest.AutoWiringService;
import b_ioc.springtest.Test2Class;
import b_ioc.springtest.TestClass;
import org.junit.Test;
import tools.PubUtil;

public class Spring_1_IOC_Test extends PubUtil {
    public Spring_1_IOC_Test() {
        super("classpath*:spring-*.xml");
    }

    @Test
    public void testTestClass() {
        TestClass testClass = super.getBean("test1");
        testClass.say();
    }

    @Test
    public void testTest2Class() {
        Test2Class test2Class = getBean("test2");
    }

    @Test
    public void testTestApplicationContextAware() {
//        TestBeanAware testBeanAware=getBean("ApplicationContextAware");
    }

    @Test
    public void testTestBeanAware() {
        System.out.println("testTestBeanAware: " + getBean("BeanAwareName"));
    }

    @Test
    public void testAutoWiringService() {
        AutoWiringService autoWiringService = getBean("autoWiringService");
        autoWiringService.say("Test");
    }

    @Test
    public void testBeanAnnotationSay() {
        BeanAnnotation beanAnnotation = getBean("beanAnnotation");
        beanAnnotation.say("This is a Test");
    }

    @Test
    public void testMultiBean() {
        BeanInvoker beanInvoker = super.getBean("beanInvoker");
        beanInvoker.say();
        beanInvoker.saybeanImpl1();
    }
}
