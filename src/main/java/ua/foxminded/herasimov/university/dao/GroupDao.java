package ua.foxminded.herasimov.university.dao;

import ua.foxminded.herasimov.university.entity.Group;

import java.util.Optional;

public interface GroupDao extends Dao<Integer, Group> {

    Optional<Group> getGroupByStudentId(Integer studentId);
}
