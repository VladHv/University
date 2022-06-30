package ua.foxminded.herasimov.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.impl.TeacherDaoImpl;
import ua.foxminded.herasimov.university.entity.Teacher;
import ua.foxminded.herasimov.university.exception.ServiceException;
import ua.foxminded.herasimov.university.service.TeacherService;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);
    private TeacherDaoImpl dao;

    @Autowired
    public TeacherServiceImpl(TeacherDaoImpl dao) {
        this.dao = dao;
    }

    public int create(Teacher teacher) {
        logger.info("Starting create: {}", teacher);
        try {
            return dao.create(teacher);
        } catch (RuntimeException e) {
            logger.error("Teacher {} cannot be found", teacher);
            throw new ServiceException("Not created: " + teacher.toString(), e);
        }
    }

    public Optional<Teacher> findById(Integer id) {
        logger.info("Finding teacher by id: {}", id);
        try {
            return Optional.ofNullable(dao.findById(id));
        } catch (RuntimeException e) {
            logger.error("Teacher with id '{}' cannot be found", id);
            throw new ServiceException("Teacher not found by id: " + id, e);
        }
    }

    public int update(Teacher teacher) {
        logger.info("Updating teacher {}", teacher);
        try {
            return dao.update(teacher);
        } catch (RuntimeException e) {
            logger.error("Teacher {} cannot be updated", teacher);
            throw new ServiceException("Not updated: " + teacher, e);
        }
    }

    public int delete(Teacher teacher) {
        logger.info("Deleting teacher: {}", teacher);
        try {
            return dao.delete(teacher);
        } catch (RuntimeException e) {
            logger.error("Teacher {} cannot be deleted", teacher);
            throw new ServiceException("Not deleted: " + teacher, e);
        }
    }

    public int delete(Integer id) {
        logger.info("Deleting teacher by id: {}", id);
        try {
            return dao.delete(id);
        } catch (RuntimeException e) {
            logger.error("Teacher with id '{}' cannot be deleted", id);
            throw new ServiceException("Teacher by id: " + id + " not deleted", e);
        }
    }

    public Optional<List<Teacher>> findAll() {
        logger.info("Staring to find all teachers");
        try {
            return Optional.ofNullable(dao.findAll());
        } catch (RuntimeException e) {
            logger.info("All teachers not found");
            throw new ServiceException("All teachers not found", e);
        }
    }
}
