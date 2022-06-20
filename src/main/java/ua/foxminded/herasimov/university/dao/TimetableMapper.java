package ua.foxminded.herasimov.university.dao;

import org.springframework.jdbc.core.RowMapper;
import ua.foxminded.herasimov.university.entity.Timetable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TimetableMapper implements RowMapper<Timetable> {

    @Override
    public Timetable mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Timetable.Builder().withId(rs.getInt("id"))
                                      .withLessonId(rs.getInt("lesson_id"))
                                      .withTeacherId(rs.getInt("teacher_id"))
                                      .withGroupId(rs.getInt("group_id"))
                                      .withDay(rs.getInt("day"))
                                      .withTime(rs.getTime("time").toLocalTime())
                                      .build();
    }
}
