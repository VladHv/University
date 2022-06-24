package ua.foxminded.herasimov.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.impl.GroupDaoImpl;
import ua.foxminded.herasimov.university.entity.Group;
import ua.foxminded.herasimov.university.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupDaoImpl dao;

    @Autowired
    public GroupServiceImpl(GroupDaoImpl dao) {
        this.dao = dao;
    }

    public Group getGroupByStudentId(Integer id) {
        Integer groupId = dao.getGroupIdByStudentId(id);
        return dao.findById(groupId);
    }

    public int create (Group group) {
        return dao.create(group);
    }

    public Group findById(Integer id) {
        return dao.findById(id);
    }

    public int update(Group group) {
        return dao.update(group);
    }

    public int delete(Integer id) {
        return dao.delete(id);
    }

    public int delete(Group group) {
        return dao.delete(group);
    }

    public List<Group> findAll() {
        return dao.findAll();
    }

}
