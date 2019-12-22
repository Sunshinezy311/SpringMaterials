import aop.aop_config.AspectBiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class AopTest extends PubUtil {
    public AopTest(){
        super("classpath:spring-4-Aop.xml");
    }

    @Test
    public void testAopConfig(){
        AspectBiz biz=super.getBean("aspectBiz");
        biz.biz();
    }
}
