package ua.foxminded.herasimov.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.impl.GroupDaoImpl;
import ua.foxminded.herasimov.university.entity.Group;
import ua.foxminded.herasimov.university.exception.ServiceException;
import ua.foxminded.herasimov.university.service.GroupService;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    private static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
    private final GroupDaoImpl dao;

    @Autowired
    public GroupServiceImpl(GroupDaoImpl dao) {
        this.dao = dao;
    }

    public Optional<Group> getGroupByStudentId(Integer id) {
        logger.info("Getting group by student id: {}", id);
        try {
            logger.info("Getting group ID by student ID: {}", id);
            Group group = dao.getGroupByStudentId(id);
            return Optional.ofNullable(group);
        } catch (DataAccessException e) {
            logger.error("Group not found by Student id: {}", id);
            throw new ServiceException("Group not found by Student id - " + id, e);
        }
    }

    public void create(Group group) {
        logger.info("Starting create: {}", group);
        try {
            dao.create(group);
        } catch (DataAccessException e) {
            logger.error("Group {} cannot be found", group);
            throw new ServiceException("Not created: " + group.toString(), e);
        }
    }

    public Optional<Group> findById(Integer id) {
        logger.info("Finding group by id: {}", id);
        try {
            return Optional.ofNullable(dao.findById(id));
        } catch (DataAccessException e) {
            logger.error("Group with id '{}' cannot be found", id);
            throw new ServiceException("Group not found by id: " + id, e);
        }
    }

    public void update(Group group) {
        logger.info("Updating group {}", group);
        try {
            dao.update(group);
        } catch (DataAccessException e) {
            logger.error("Group {} cannot be updated", group);
            throw new ServiceException("Not updated: " + group, e);
        }
    }

    public void delete(Integer id) {
        logger.info("Deleting group by id: {}", id);
        try {
            dao.delete(id);
        } catch (DataAccessException e) {
            logger.error("Group with id '{}' cannot be deleted", id);
            throw new ServiceException("Group by id: " + id + " not deleted", e);
        }
    }

    public void delete(Group group) {
        logger.info("Deleting group: {}", group);
        try {
            dao.delete(group);
        } catch (DataAccessException e) {
            logger.error("Group {} cannot be deleted", group);
            throw new ServiceException("Not deleted: " + group, e);
        }
    }

    public Optional<List<Group>> findAll() {
        logger.info("Staring to find all groups");
        try {
            return Optional.ofNullable(dao.findAll());
        } catch (DataAccessException e) {
            logger.info("All groups not found");
            throw new ServiceException("All groups not found", e);
        }
    }
}
