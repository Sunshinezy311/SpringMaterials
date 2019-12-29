package unused;

import ioc.springtest.AutoWiringService;
import ioc.springtest.Test2Class;
import ioc.springtest.TestClass;
import bean_test.bean_context.BeanAnnotation;
import bean_test.bean_in_code.Store;
import bean_test.bean_load_resfiles.MyDriverManager;
import bean_test.genericity_autowired.Store1;
import bean_test.multi_bean.BeanInvoker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import bean_test.spring_support_jsr.JsrService;
import tools.PubUtil;

@RunWith(BlockJUnit4ClassRunner.class)
public class BeanTest extends PubUtil {
    public BeanTest(){
        super("classpath*:spring-1-IOC.xml");
    }

    @Test
    public void testBeanInConfig() {
        //注意，需要加    <context:component-scan base-package="bean_test.bean_in_code"/> 否则spring也不知道你要扫哪里
        Store store = super.getBean("getStringStore");
        System.out.println(store.getClass().getName());
    }

    @Test
    public void testBeanLoadResFiles() {
        MyDriverManager myDriverManager = super.getBean("myDriverManager");
        System.out.println(myDriverManager.getClass().getName());
    }

    @Test
    public void testGenericityAutowired() {
        Store1 store1 = super.getBean("stringStoreTest1");

    }

    @Test
    public void testSpringSupportJsr() {
        JsrService jsrService = super.getBean("jsrService");
        jsrService.save();
    }
}
