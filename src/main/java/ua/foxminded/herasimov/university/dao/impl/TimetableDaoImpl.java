package ua.foxminded.herasimov.university.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.foxminded.herasimov.university.dao.TimetableDao;
import ua.foxminded.herasimov.university.dao.mapper.TimetableMapper;
import ua.foxminded.herasimov.university.entity.Timetable;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TimetableDaoImpl implements TimetableDao {

    private final JdbcTemplate jdbcTemplate;

    public TimetableDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Timetable entity) {
        jdbcTemplate.update(
            "INSERT INTO timetables (lesson_id, teacher_id, group_id, day, time) VALUES (?, ?, ?, ?, ?)",
            entity.getLessonId(),
            entity.getTeacherId(),
            entity.getGroupId(),
            entity.getDay(),
            entity.getTime());
    }

    @Override
    public Timetable findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM timetables WHERE id = (?)", new TimetableMapper(), id);
    }

    @Override
    public void update(Timetable entity) {
        jdbcTemplate.update(
            "UPDATE timetables SET lesson_id = (?), teacher_id = (?), group_id = (?), day = (?), time = (?) WHERE id = (?)",
            entity.getLessonId(),
            entity.getTeacherId(),
            entity.getGroupId(),
            entity.getDay(),
            entity.getTime(),
            entity.getId());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM timetables WHERE id = (?)", id);
    }

    @Override
    public void delete(Timetable entity) {
        jdbcTemplate.update("DELETE FROM timetables WHERE id = (?)", entity.getId());
    }

    @Override
    public List<Timetable> findAll() {
        return jdbcTemplate.query("SELECT * FROM timetables", new TimetableMapper());
    }
}
