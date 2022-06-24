package ua.foxminded.herasimov.university.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.foxminded.herasimov.university.entity.Lesson;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LessonMapper implements RowMapper<Lesson> {
    @Override
    public Lesson mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Lesson.Builder().withId(rs.getInt("id"))
                                   .withName(rs.getString("name"))
                                   .withClassroom(rs.getInt("classroom"))
                                   .build();
    }
}
