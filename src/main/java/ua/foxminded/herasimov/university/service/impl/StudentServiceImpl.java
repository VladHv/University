package ua.foxminded.herasimov.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.StudentDao;
import ua.foxminded.herasimov.university.entity.Student;
import ua.foxminded.herasimov.university.exception.ServiceException;
import ua.foxminded.herasimov.university.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    private StudentDao dao;

    @Autowired
    public StudentServiceImpl(StudentDao dao) {
        this.dao = dao;
    }

    public void create(Student student) {
        logger.info("Starting create: {}", student);
        try {
            dao.create(student);
        } catch (DataAccessException e) {
            logger.error("Student {} cannot be found", student);
            throw new ServiceException("Not created: " + student.toString(), e);
        }
    }

    public Optional<Student> findById(Integer id) {
        logger.info("Finding student by id: {}", id);
        try {
            return Optional.ofNullable(dao.findById(id));
        } catch (DataAccessException e) {
            logger.error("Student with id '{}' cannot be found", id);
            throw new ServiceException("Student not found by id: " + id, e);
        }
    }

    public void update(Student student) {
        logger.info("Updating student {}", student);
        try {
            dao.update(student);
        } catch (DataAccessException e) {
            logger.error("Student {} cannot be updated", student);
            throw new ServiceException("Not updated: " + student, e);
        }
    }

    public void delete(Integer id) {
        logger.info("Deleting student by id: {}", id);
        try {
            dao.delete(id);
        } catch (DataAccessException e) {
            logger.error("Student with id '{}' cannot be deleted", id);
            throw new ServiceException("Student by id: " + id + " not deleted", e);
        }
    }

    public void delete(Student student) {
        logger.info("Deleting student: {}", student);
        try {
            dao.delete(student);
        } catch (DataAccessException e) {
            logger.error("Student {} cannot be deleted", student);
            throw new ServiceException("Not deleted: " + student, e);
        }
    }

    public Optional<List<Student>> findAll() {
        logger.info("Staring to find all students");
        try {
            return Optional.ofNullable(dao.findAll());
        } catch (DataAccessException e) {
            logger.info("All students not found");
            throw new ServiceException("All students not found", e);
        }
    }
}
