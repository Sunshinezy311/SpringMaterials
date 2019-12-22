import di.applications_dl.CollectionDiMain;
import di.applications_dl.InnerBeansDiMain;
import di.constructor_di.ConstructDiMain;
import di.setter_di.SetterDiMian;
import org.junit.Test;

public class Spring_2_DI_Test extends PubUtil {
    public Spring_2_DI_Test() {
        super("classpath*:spring-2-DI.xml");
    }

    @Test
    public void test_Constructor_DI() {
        ConstructDiMain te = (ConstructDiMain) super.getBean("constructdimain");
        te.run();
    }

    @Test
    public void test_Constructor_DI_MultiRef() {
        ConstructDiMain te = (ConstructDiMain) super.getBean("constructdimain");
        te.run();
        te.run1();
    }

    @Test
    public void testSetter_DI() {
        SetterDiMian te = (SetterDiMian) super.getBean("setterDiMian");
        te.run();
    }

    @Test
    public void test_Applications_DI() {
        //内部bean注入方式
        InnerBeansDiMain te = (InnerBeansDiMain) super.getBean("innerBeansDiMain");
        te.run();

        //注入集合
        CollectionDiMain collectionDiMain = (CollectionDiMain) super.getBean("collectionDiMain");
        collectionDiMain.getAddressList();
        collectionDiMain.getAddressSet();
        collectionDiMain.getAddressMap();
        collectionDiMain.getAddressProp();
    }

}
