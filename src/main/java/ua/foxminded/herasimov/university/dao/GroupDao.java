package ua.foxminded.herasimov.university.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class GroupDao {

    private final JdbcTemplate jdbcTemplate;

    public GroupDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Integer getGroupByStudentId(Integer studentId) {
        return jdbcTemplate.queryForObject("SELECT group_id FROM students WHERE id = (?)", Integer.class, studentId);
    }
}
