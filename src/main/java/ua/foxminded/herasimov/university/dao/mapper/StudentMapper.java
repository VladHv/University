package ua.foxminded.herasimov.university.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.foxminded.herasimov.university.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Student.Builder().withId(rs.getInt("id"))
                                    .withFirstName(rs.getString("first_name"))
                                    .withLastName(rs.getString("last_name"))
                                    .withFaculty(rs.getString("faculty"))
                                    .withTicket(rs.getInt("ticket"))
                                    .build();
    }
}
