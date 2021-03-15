import g_jdbc.JDBCStudent;
import g_jdbc.StudentJDBCTemplate;
import org.junit.Test;
import tools.PubUtil;
import h_transaction.programmatic.ProgStudentMarks;
import h_transaction.programmatic.StdProgTransJdbcTemp;
import h_transaction.reputation.RepStudentMarks;
import h_transaction.reputation.StdRepTransJdbcTemp;

import java.util.List;

public class Spring_5_Jdbc_Test extends PubUtil {
    public Spring_5_Jdbc_Test() {
        super("classpath*:spring-5-jdbc.xml");
    }

    @Test
    public void test_jdbc_functions() {
        StudentJDBCTemplate studentJDBCTemplate =
                (StudentJDBCTemplate) getBean("studentJDBCTemplate");
        System.out.println("------Records Creation--------");
        studentJDBCTemplate.create("Zara", 11);
        studentJDBCTemplate.create("Nuha", 2);
        studentJDBCTemplate.create("Ayan", 15);
        System.out.println("------Listing Multiple Records--------");
        List<JDBCStudent> JDBCStudents = studentJDBCTemplate.listStudents();
        for (JDBCStudent record : JDBCStudents) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.println(", Age : " + record.getAge());
        }
        System.out.println("----Updating Record with ID = 2 -----");
        studentJDBCTemplate.update(2, 20);
        System.out.println("----Listing Record with ID = 2 -----");
        JDBCStudent JDBCStudent = studentJDBCTemplate.getStudent(2);
        System.out.print("ID : " + JDBCStudent.getId());
        System.out.print(", Name : " + JDBCStudent.getName());
        System.out.println(", Age : " + JDBCStudent.getAge());

        System.out.println("----Listing Inited Table -----");
        studentJDBCTemplate.initTable();
        JDBCStudents = studentJDBCTemplate.listStudents();
        if (JDBCStudents.size() == 0) {
            System.out.println("The Tbale Student is empty!");
        }
    }

    //编程式事务管理
    @Test
    public void test_programmatic_transaction_management() {
        StdProgTransJdbcTemp stdProgTransJdbcTemp =
                (StdProgTransJdbcTemp) getBean("stdProgTransJdbcTemp");
        System.out.println("------Records creation--------");
        stdProgTransJdbcTemp.create("Zara", 11, 99, 2010);
        stdProgTransJdbcTemp.create("Nuha", 20, 97, 2010);
        stdProgTransJdbcTemp.create("Ayan", 25, 100, 2011);
        System.out.println("------Listing all the records--------");
        List<ProgStudentMarks> progStudentMarks = stdProgTransJdbcTemp.listStudents();
        for (ProgStudentMarks record : progStudentMarks) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.print(", Marks : " + record.getMarks());
            System.out.print(", Year : " + record.getYear());
            System.out.println(", Age : " + record.getAge());
        }
    }


    //声名式事务管理
    @Test(expected = RuntimeException.class)
    public void test_reputaion_transaction_management() {
        StdRepTransJdbcTemp stdRepTransJdbcTemp =
                (StdRepTransJdbcTemp) getBean("stdRepTransJdbcTemp");
        System.out.println("------Records creation--------");
        stdRepTransJdbcTemp.create("Zara", 11, 99, 2010);
        stdRepTransJdbcTemp.create("Nuha", 20, 97, 2010);
        stdRepTransJdbcTemp.create("Ayan", 25, 100, 2011);
        System.out.println("------Listing all the records--------");
        List<RepStudentMarks> repStudentMarks = stdRepTransJdbcTemp.listStudents();
        for (RepStudentMarks record : repStudentMarks) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.print(", Marks : " + record.getMarks());
            System.out.print(", Year : " + record.getYear());
            System.out.println(", Age : " + record.getAge());
        }
    }
}
