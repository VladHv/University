package ua.foxminded.herasimov.university.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.foxminded.herasimov.university.dao.GroupDao;
import ua.foxminded.herasimov.university.dao.mapper.GroupMapper;
import ua.foxminded.herasimov.university.entity.Group;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class GroupDaoImpl implements GroupDao {

    private final JdbcTemplate jdbcTemplate;

    public GroupDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Integer getGroupIdByStudentId(Integer studentId) {
        return jdbcTemplate.queryForObject("SELECT group_id FROM students WHERE id = (?)", Integer.class, studentId);
    }

    @Override
    public void create(Group entity) {
        jdbcTemplate.update("INSERT INTO groups (name) VALUES (?)", entity.getName());
    }

    @Override
    public Group findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM groups WHERE id = (?)", new GroupMapper(), id);
    }

    @Override
    public void update(Group entity) {
        jdbcTemplate.update("UPDATE groups SET name = (?) WHERE id = (?)", entity.getName(), entity.getId());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM groups WHERE id = (?)", id);
    }

    @Override
    public void delete(Group entity) {
        jdbcTemplate.update("DELETE FROM groups WHERE id = (?)", entity.getId());
    }

    @Override
    public List<Group> findAll() {
        return jdbcTemplate.query("SELECT * FROM groups", new GroupMapper());
    }
}
