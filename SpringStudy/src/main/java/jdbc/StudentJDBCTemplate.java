package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        init(jdbcTemplateObject);
    }

    // show tables from TEST;
    // drop table TEST.student;
    // show columns from TEST.Student;
    public void init(JdbcTemplate jdbcTemplateObject) {
        String dropDataBaseSQL = "drop table if exists TEST.Student";
        jdbcTemplateObject.update(dropDataBaseSQL);
        String createTableSql = "create table TEST.Student(\n" +
                "   id int not null auto_increment,\n" +
                "   name varchar(20) not null,\n" +
                "   age int not null,\n" +
                "   primary key (id)\n" +
                ")";
        System.out.println(createTableSql);
        jdbcTemplateObject.update(createTableSql);
    }

    public void create(String name, Integer age) {
        String SQL = "insert into Student (name, age) values (?, ?)";
        jdbcTemplateObject.update(SQL, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
        return;
    }

    public JDBCStudent getStudent(Integer id) {
        String SQL = "select * from Student where id = ?";
        JDBCStudent JDBCStudent = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new StudentMapper());
        return JDBCStudent;
    }

    public List<JDBCStudent> listStudents() {
        String SQL = "select * from Student";
        List<JDBCStudent> JDBCStudents = jdbcTemplateObject.query(SQL, new StudentMapper());
        return JDBCStudents;
    }

    public void delete(Integer id) {
        String SQL = "delete from Student where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
        return;
    }

    public void update(Integer id, Integer age) {
        String SQL = "update Student set age = ? where id = ?";
        jdbcTemplateObject.update(SQL, age, id);
        System.out.println("Updated Record with ID = " + id);
        return;
    }

    public void initTable() {
        String SQL = "truncate table TEST.Student";
        jdbcTemplateObject.update(SQL);
    }
}
