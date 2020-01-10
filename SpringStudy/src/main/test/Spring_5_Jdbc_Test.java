import jdbc.JDBCStudent;
import jdbc.StudentJDBCTemplate;
import org.junit.Test;
import tools.PubUtil;

import java.util.List;

public class Spring_5_Jdbc_Test extends PubUtil {
    public Spring_5_Jdbc_Test() {
        super("classpath*:spring-5-jdbc.xml");
    }

    @Test
    public void test_jdbc_functions(){
        StudentJDBCTemplate studentJDBCTemplate =
                (StudentJDBCTemplate) getBean("studentJDBCTemplate");
        System.out.println("------Records Creation--------" );
        studentJDBCTemplate.create("Zara", 11);
        studentJDBCTemplate.create("Nuha", 2);
        studentJDBCTemplate.create("Ayan", 15);
        System.out.println("------Listing Multiple Records--------" );
        List<JDBCStudent> JDBCStudents = studentJDBCTemplate.listStudents();
        for (JDBCStudent record : JDBCStudents) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Age : " + record.getAge());
        }
        System.out.println("----Updating Record with ID = 2 -----" );
        studentJDBCTemplate.update(2, 20);
        System.out.println("----Listing Record with ID = 2 -----" );
        JDBCStudent JDBCStudent = studentJDBCTemplate.getStudent(2);
        System.out.print("ID : " + JDBCStudent.getId() );
        System.out.print(", Name : " + JDBCStudent.getName() );
        System.out.println(", Age : " + JDBCStudent.getAge());
    }
}
