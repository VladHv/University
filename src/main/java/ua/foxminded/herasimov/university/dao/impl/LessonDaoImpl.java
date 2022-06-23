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
    public int create(Lesson entity) {
        return jdbcTemplate.update("INSERT INTO lessons (name, classroom) VALUES (?, ?)",
                            entity.getName(),
                            entity.getClassroom());
    }

    @Override
    public Lesson findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM lessons WHERE id = (?)", new LessonMapper(), id);
    }

    @Override
    public int update(Lesson entity) {
        return jdbcTemplate.update("UPDATE lessons SET name = (?), classroom = (?) WHERE id = (?)",
                            entity.getName(),
                            entity.getClassroom(),
                            entity.getId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM lessons WHERE id = (?)", id);
    }

    @Override
    public int delete(Lesson entity) {
        return jdbcTemplate.update("DELETE FROM lessons WHERE id = (?)", entity.getId());
    }

    @Override
    public List<Lesson> findAll() {
        return jdbcTemplate.query("SELECT * FROM lessons", new LessonMapper());
    }
}
