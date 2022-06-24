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
    public int create(Student entity) {
        return jdbcTemplate.update("INSERT INTO students (first_name, last_name, faculty, ticket) VALUES (?, ?, ?, ?)",
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
    public int update(Student entity) {
        return jdbcTemplate.update("UPDATE students SET first_name = (?), last_name = (?), faculty = (?), ticket = (?) " +
                             "WHERE" +
                            " id = (?)",
                            entity.getFirstName(),
                            entity.getLastName(),
                            entity.getFaculty(),
                            entity.getTicket(),
                            entity.getId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM students WHERE id = (?)", id);
    }

    @Override
    public int delete(Student entity) {
        return jdbcTemplate.update("DELETE FROM students WHERE id = (?)", entity.getId());
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM students", new StudentMapper());
    }
}
