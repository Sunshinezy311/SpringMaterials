import autowire.byname.AutoWireByNameMain;
import autowire.bytype.AutoWireByTypeMain;
import autowire.constructor.AutoWiredByConstructorMain;
import org.junit.Test;

public class Spring_3_AutoWire_Test extends PubUtil {
    public Spring_3_AutoWire_Test() {
        super("classpath*:spring-3-AutoWire.xml");
    }

    @Test
    public void test_AutoWire_ByName_DI() {
        AutoWireByNameMain te = (AutoWireByNameMain) super.getBean("autoWireByNameMain");
        te.run();
    }

    @Test
    public void test_AutoWire_ByType_DI() {
        AutoWireByTypeMain te = (AutoWireByTypeMain) super.getBean("autoWiredByTypeMain");
        te.run();
    }

    @Test
    public void test_AutoWare_Constructor_DI() {
        AutoWiredByConstructorMain te = (AutoWiredByConstructorMain) super.getBean("autoWiredByConstructorMain");
        te.run();
    }
}
