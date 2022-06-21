package ua.foxminded.herasimov.university.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.foxminded.herasimov.university.entity.Teacher;
import ua.foxminded.herasimov.university.entity.TeacherPosition;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Teacher.Builder().withId(rs.getInt("id"))
                                    .withFirstName(rs.getString("first_name"))
                                    .withLastName(rs.getString("last_name"))
                                    .withDepartment(rs.getString("department"))
                                    .withPosition(TeacherPosition.values()[rs.getInt("position") - 1])
                                    .build();
    }
}
