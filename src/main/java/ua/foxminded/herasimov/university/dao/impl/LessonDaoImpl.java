package ua.foxminded.herasimov.university.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.foxminded.herasimov.university.dao.LessonDao;
import ua.foxminded.herasimov.university.dao.mapper.LessonMapper;
import ua.foxminded.herasimov.university.entity.Lesson;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class LessonDaoImpl implements LessonDao {

    private JdbcTemplate jdbcTemplate;

    public LessonDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Lesson entity) {
        jdbcTemplate.update("INSERT INTO lessons (name, classroom) VALUES (?, ?)",
                            entity.getName(),
                            entity.getClassroom());
    }

    @Override
    public Lesson findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM lessons WHERE id = (?)", new LessonMapper(), id);
    }

    @Override
    public void update(Lesson entity) {
        jdbcTemplate.update("UPDATE lessons SET name = (?), classroom = (?) WHERE id = (?)",
                            entity.getName(),
                            entity.getClassroom(),
                            entity.getId());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM lessons WHERE id = (?)", id);
    }

    @Override
    public void delete(Lesson entity) {
        jdbcTemplate.update("DELETE FROM lessons WHERE id = (?)", entity.getId());
    }

    @Override
    public List<Lesson> findAll() {
        return jdbcTemplate.query("SELECT * FROM lessons", new LessonMapper());
    }
}
