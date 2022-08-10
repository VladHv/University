package ua.foxminded.herasimov.university.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.foxminded.herasimov.university.entity.Timetable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TimetableMapper implements RowMapper<Timetable> {

    @Override
    public Timetable mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Timetable.Builder().withId(rs.getInt("id"))
//                                      .withLesson(rs.getInt("lesson_id"))
//                                      .withTeacher(rs.getInt("teacher_id"))
//                                      .withGroup(rs.getInt("group_id"))
//                                      .withDay(rs.getInt("day"))
                                      .withTime(rs.getTime("time").toLocalTime())
                                      .build();
    }
}
