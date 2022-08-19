package ua.foxminded.herasimov.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.TeacherDao;
import ua.foxminded.herasimov.university.entity.Teacher;
import ua.foxminded.herasimov.university.exception.ServiceException;
import ua.foxminded.herasimov.university.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);
    private TeacherDao dao;

    @Autowired
    public TeacherServiceImpl(TeacherDao dao) {
        this.dao = dao;
    }

    public void create(Teacher teacher) {
        logger.info("Starting create: {}", teacher);
        try {
            dao.create(teacher);
        } catch (RuntimeException e) {
            logger.error("Teacher {} cannot be found", teacher);
            throw new ServiceException("Not created: " + teacher.toString(), e);
        }
    }

    public Teacher findById(Integer id) {
        logger.info("Finding teacher by id: {}", id);
        return dao.findById(id).orElseThrow(() -> new ServiceException("Teacher not found by id: " + id));
    }

    public void update(Teacher teacher) {
        logger.info("Updating teacher {}", teacher);
        try {
            dao.update(teacher);
        } catch (RuntimeException e) {
            logger.error("Teacher {} cannot be updated", teacher);
            throw new ServiceException("Not updated: " + teacher, e);
        }
    }

    public void delete(Teacher teacher) {
        logger.info("Deleting teacher: {}", teacher);
        try {
            dao.delete(teacher);
        } catch (RuntimeException e) {
            logger.error("Teacher {} cannot be deleted", teacher);
            throw new ServiceException("Not deleted: " + teacher, e);
        }
    }

    public void delete(Integer id) {
        logger.info("Deleting teacher by id: {}", id);
        try {
            dao.delete(id);
        } catch (RuntimeException e) {
            logger.error("Teacher with id '{}' cannot be deleted", id);
            throw new ServiceException("Teacher by id: " + id + " not deleted", e);
        }
    }

    public List<Teacher> findAll() {
        logger.info("Staring to find all teachers");
        return dao.findAll().orElseThrow(() -> new ServiceException("All teachers not found"));
    }
}
