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

    public void init(JdbcTemplate jdbcTemplateObject) {
        String dropDataBaseSQL = "drop table if exists TEST.Student";
        jdbcTemplateObject.update(dropDataBaseSQL);
        String createTableSql = "create table TEST.Student (id int(11), name VARCHAR(255), age int(11))";
        jdbcTemplateObject.update(createTableSql);
    }

    public void create(Integer id, String name, Integer age) {
        String SQL = "insert into Student (id, name, age) values (?, ?, ?)";
        jdbcTemplateObject.update(SQL, id, name, age);
        System.out.println("Created Record ID = " + id + "Name = " + name + " Age = " + age);
        return;
    }

    public JDBCStudent getStudent(Integer id) {
        String SQL = "select * from Student where id = ?";
        JDBCStudent JDBCStudent = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new StudentMapper());
        return JDBCStudent;
    }

    public List<JDBCStudent> listStudents() {
        String SQL = "select * from Student";
        List<JDBCStudent> JDBCStudents = jdbcTemplateObject.query(SQL,
                new StudentMapper());
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
