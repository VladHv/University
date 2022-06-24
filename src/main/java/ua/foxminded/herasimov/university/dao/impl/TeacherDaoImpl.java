package ua.foxminded.herasimov.university.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.foxminded.herasimov.university.dao.TeacherDao;
import ua.foxminded.herasimov.university.dao.mapper.TeacherMapper;
import ua.foxminded.herasimov.university.entity.Teacher;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    private JdbcTemplate jdbcTemplate;

    public TeacherDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int create(Teacher entity) {
        return jdbcTemplate.update("INSERT INTO teachers (first_name, last_name, department, position) VALUES (?, ?, ?, ?)",
                            entity.getFirstName(),
                            entity.getLastName(),
                            entity.getDepartment(),
                            entity.getPosition().ordinal() + 1);
    }

    @Override
    public Teacher findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM teachers WHERE id = (?)", new TeacherMapper(), id);
    }

    @Override
    public int update(Teacher entity) {
        return jdbcTemplate.update(
            "UPDATE teachers SET first_name = (?), last_name = (?), department = (?), position = (?) WHERE" +
            " id = (?)",
            entity.getFirstName(),
            entity.getLastName(),
            entity.getDepartment(),
            entity.getPosition().ordinal() + 1,
            entity.getId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM teachers WHERE id = (?)", id);
    }

    @Override
    public int delete(Teacher entity) {
        return jdbcTemplate.update("DELETE FROM teachers WHERE id = (?)", entity.getId());
    }

    @Override
    public List<Teacher> findAll() {
        return jdbcTemplate.query("SELECT * FROM teachers", new TeacherMapper());
    }
}
