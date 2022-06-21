package ua.foxminded.herasimov.university.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.foxminded.herasimov.university.dao.StudentDao;
import ua.foxminded.herasimov.university.dao.mapper.StudentMapper;
import ua.foxminded.herasimov.university.entity.Student;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Student entity) {
        jdbcTemplate.update("INSERT INTO students (first_name, last_name, faculty, ticket) VALUES (?, ?, ?, ?)",
                            entity.getFirstName(),
                            entity.getLastName(),
                            entity.getFaculty(),
                            entity.getTicket());
    }

    @Override
    public Student findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM students WHERE id = (?)", new StudentMapper(), id);
    }

    @Override
    public void update(Student entity) {
        jdbcTemplate.update("UPDATE students SET first_name = (?), last_name = (?), faculty = (?), ticket = (?) WHERE" +
                            " id = (?)",
                            entity.getFirstName(),
                            entity.getLastName(),
                            entity.getFaculty(),
                            entity.getTicket(),
                            entity.getId());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM students WHERE id = (?)", id);
    }

    @Override
    public void delete(Student entity) {
        jdbcTemplate.update("DELETE FROM students WHERE id = (?)", entity.getId());
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM students", new StudentMapper());
    }
}
