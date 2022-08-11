package ua.foxminded.herasimov.university.dao;

import ua.foxminded.herasimov.university.entity.Group;

public interface GroupDao extends Dao<Integer, Group> {

    Group getGroupByStudentId(Integer studentId);
}
