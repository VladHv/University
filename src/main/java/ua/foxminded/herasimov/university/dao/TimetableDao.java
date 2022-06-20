package ua.foxminded.herasimov.university.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ua.foxminded.herasimov.university.entity.Timetable;

import javax.sql.DataSource;
import java.util.List;

public class TimetableDao {

    private final JdbcTemplate jdbcTemplate;

    public TimetableDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Timetable> findAll() {
        return jdbcTemplate.query("SELECT * FROM timetables", new TimetableMapper());
    }
}
