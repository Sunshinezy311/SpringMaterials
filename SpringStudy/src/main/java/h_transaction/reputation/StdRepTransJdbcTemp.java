package h_transaction.reputation;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.List;

public class StdRepTransJdbcTemp {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    //PlatformTransactionManager 来实现编程式方法从而实现事务
    private PlatformTransactionManager transactionManager;

    //用于初始化数据库访问
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        init(jdbcTemplateObject);
    }

    //初始化事务管理
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void init(JdbcTemplate jdbcTemplateObject) {
        // show tables from TEST;
        // drop table TEST.student;
        // show columns from TEST.Student;
        String createTableSql = "drop table if exists test.student; \n" +
                "create table test.student(\n" +
                "   id int not null auto_increment, \n" +
                "   name varchar(20) not null, \n" +
                "   age int not null, \n" +
                "   primary key (id) \n" +
                ");" +
                "drop table if exists test.marks; \n" +
                "create table test.marks( \n" +
                "   sid int not null, \n" +
                "   marks  int not null, \n" +
                "   year   int not null \n" +
                ") ";
        System.out.println(createTableSql);
        //批量执行sql用法
        jdbcTemplateObject.batchUpdate(createTableSql.split(";"));
    }

    public void create(String name, Integer age, Integer marks, Integer year) {
        //根据指定的传播行为，该方法返回当前活动事务或创建一个新的事务。
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            String SQL1 = "insert into Student (name, age) values (?, ?)";
            jdbcTemplateObject.update(SQL1, name, age);
            // Get the latest student id to be used in Marks table
            String SQL2 = "select max(id) from Student";
            Integer sid = jdbcTemplateObject.queryForObject(SQL2, Integer.class);
            String SQL3 = "insert into Marks(sid, marks, year) values (?, ?, ?)";
            jdbcTemplateObject.update(SQL3, sid, marks, year);
            System.out.println("Created Name = " + name + ", Age = " + age);
            //该方法提交给定的事务和关于它的状态。
            transactionManager.commit(status);
            throw new RuntimeException("simulate Error condition") ;
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            //该方法执行一个给定事务的回滚。
            transactionManager.rollback(status);
            throw e;
        }
    }

    public List<RepStudentMarks> listStudents() {
        String SQL = "select * from Student, Marks where Student.id=Marks.sid";
        //Mapper，用于将对应的字段结果存入对应对象里的成员变量，是一种映射关系，这样写的好处多多
        return jdbcTemplateObject.query(SQL, new StudentMarksMapper());
    }
}
