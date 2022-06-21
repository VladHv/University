package ua.foxminded.herasimov.university.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.foxminded.herasimov.university.entity.Group;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupMapper implements RowMapper<Group> {
    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Group.Builder().withId(rs.getInt("id"))
                                  .withName(rs.getString("name"))
                                  .build();
    }
}
