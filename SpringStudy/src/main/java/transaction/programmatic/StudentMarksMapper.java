package transaction.programmatic;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMarksMapper implements RowMapper<ProgStudentMarks> {
    public ProgStudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProgStudentMarks progStudentMarks = new ProgStudentMarks();
        progStudentMarks.setId(rs.getInt("id"));
        progStudentMarks.setName(rs.getString("name"));
        progStudentMarks.setAge(rs.getInt("age"));
        progStudentMarks.setSid(rs.getInt("sid"));
        progStudentMarks.setMarks(rs.getInt("marks"));
        progStudentMarks.setYear(rs.getInt("year"));
        return progStudentMarks;
    }

}
