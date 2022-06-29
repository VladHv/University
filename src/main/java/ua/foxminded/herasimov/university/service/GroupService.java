package ua.foxminded.herasimov.university.service;

import ua.foxminded.herasimov.university.entity.Group;

import java.util.Optional;

public interface GroupService extends Service<Integer, Group> {

    Optional<Group> getGroupByStudentId(Integer id);
}
