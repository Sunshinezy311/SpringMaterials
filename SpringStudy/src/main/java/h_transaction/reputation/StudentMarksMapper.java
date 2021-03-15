package h_transaction.reputation;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMarksMapper implements RowMapper<RepStudentMarks> {
    public RepStudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
        RepStudentMarks repStudentMarks = new RepStudentMarks();
        repStudentMarks.setId(rs.getInt("id"));
        repStudentMarks.setName(rs.getString("name"));
        repStudentMarks.setAge(rs.getInt("age"));
        repStudentMarks.setSid(rs.getInt("sid"));
        repStudentMarks.setMarks(rs.getInt("marks"));
        repStudentMarks.setYear(rs.getInt("year"));
        return repStudentMarks;
    }

}
