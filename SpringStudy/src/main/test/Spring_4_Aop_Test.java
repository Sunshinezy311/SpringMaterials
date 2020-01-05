import aop.xmlbased.Student;
import org.junit.Test;
import tools.PubUtil;

public class Spring_4_Aop_Test extends PubUtil {
    public Spring_4_Aop_Test() {
        super("classpath*:spring-4-Aop.xml");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_xml_based_aop() {
        Student student = (Student) getBean("student");
        System.out.println("----------------------------");
        student.getName();
        System.out.println("----------------------------");
        student.getAge();
        System.out.println("----------------------------");
        student.printThrowException();
    }
}
