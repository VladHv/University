package ua.foxminded.herasimov.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.GroupDao;
import ua.foxminded.herasimov.university.entity.Group;
import ua.foxminded.herasimov.university.exception.ServiceException;
import ua.foxminded.herasimov.university.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
    private final GroupDao dao;

    @Autowired
    public GroupServiceImpl(GroupDao dao) {
        this.dao = dao;
    }

    public Group getGroupByStudentId(Integer id) {
        logger.info("Getting group by student id: {}", id);
        return dao.getGroupByStudentId(id)
                  .orElseThrow(() -> new ServiceException("Group not found by Student id - " + id));
    }

    public void create(Group group) {
        logger.info("Starting create: {}", group);
        try {
            dao.create(group);
        } catch (RuntimeException e) {
            logger.error("Group {} cannot be found", group);
            throw new ServiceException("Not created: " + group.toString(), e);
        }
    }

    public Group findById(Integer id) {
        logger.info("Finding group by id: {}", id);
        return dao.findById(id).orElseThrow(() -> new ServiceException("Group not found by id: " + id));
    }

    public void update(Group group) {
        logger.info("Updating group {}", group);
        try {
            dao.update(group);
        } catch (RuntimeException e) {
            logger.error("Group {} cannot be updated", group);
            throw new ServiceException("Not updated: " + group, e);
        }
    }

    public void delete(Integer id) {
        logger.info("Deleting group by id: {}", id);
        try {
            dao.delete(id);
        } catch (RuntimeException e) {
            logger.error("Group with id '{}' cannot be deleted", id);
            throw new ServiceException("Group by id: " + id + " not deleted", e);
        }
    }

    public void delete(Group group) {
        logger.info("Deleting group: {}", group);
        try {
            dao.delete(group);
        } catch (RuntimeException e) {
            logger.error("Group {} cannot be deleted", group);
            throw new ServiceException("Not deleted: " + group, e);
        }
    }

    public List<Group> findAll() {
        logger.info("Staring to find all groups");
        return dao.findAll().orElseThrow(() -> new ServiceException("All groups not found"));
    }
}
