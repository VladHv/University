package ua.foxminded.herasimov.university.service;

import ua.foxminded.herasimov.university.entity.Group;

public interface GroupService extends Service<Integer, Group> {

    Group getGroupByStudentId(Integer id);
}
