import aop.by_1_xml.XmlStudent;
import aop.by_2_aspectj.AspectJStudent;
import org.junit.Test;
import tools.PubUtil;

public class Spring_4_Aop_Test extends PubUtil {
    public Spring_4_Aop_Test() {
        super("classpath*:spring-4-Aop.xml");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_xml_based_aop() {
        XmlStudent xmlStudent = (XmlStudent) getBean("xmlStudent");
        System.out.println("----------------------------");
        xmlStudent.getName();
        System.out.println("----------------------------");
        xmlStudent.getAge();
        System.out.println("----------------------------");
        xmlStudent.printThrowException();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_aspectj_based_aop() {
        AspectJStudent aspectJStudent = (AspectJStudent) getBean("aspectJStudent");
        System.out.println("----------------------------");
        aspectJStudent.getName();
        System.out.println("----------------------------");
        aspectJStudent.getAge();
        System.out.println("----------------------------");
        aspectJStudent.printThrowException();
    }
}
