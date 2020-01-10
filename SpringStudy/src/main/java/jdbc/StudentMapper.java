package jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<JDBCStudent> {
    public JDBCStudent mapRow(ResultSet rs, int rowNum) throws SQLException {
        JDBCStudent JDBCStudent = new JDBCStudent();
        JDBCStudent.setId(rs.getInt("id"));
        JDBCStudent.setName(rs.getString("name"));
        JDBCStudent.setAge(rs.getInt("age"));
        return JDBCStudent;
    }
}
