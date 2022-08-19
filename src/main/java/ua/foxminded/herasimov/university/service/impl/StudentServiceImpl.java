package ua.foxminded.herasimov.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.StudentDao;
import ua.foxminded.herasimov.university.entity.Student;
import ua.foxminded.herasimov.university.exception.ServiceException;
import ua.foxminded.herasimov.university.service.StudentService;

import java.util.List;

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
        } catch (RuntimeException e) {
            logger.error("Student {} cannot be found", student);
            throw new ServiceException("Not created: " + student.toString(), e);
        }
    }

    public Student findById(Integer id) {
        logger.info("Finding student by id: {}", id);
        return dao.findById(id).orElseThrow(() -> new ServiceException("Student not found by id: " + id));
    }

    public void update(Student student) {
        logger.info("Updating student {}", student);
        try {
            dao.update(student);
        } catch (RuntimeException e) {
            logger.error("Student {} cannot be updated", student);
            throw new ServiceException("Not updated: " + student, e);
        }
    }

    public void delete(Integer id) {
        logger.info("Deleting student by id: {}", id);
        try {
            dao.delete(id);
        } catch (RuntimeException e) {
            logger.error("Student with id '{}' cannot be deleted", id);
            throw new ServiceException("Student by id: " + id + " not deleted", e);
        }
    }

    public void delete(Student student) {
        logger.info("Deleting student: {}", student);
        try {
            dao.delete(student);
        } catch (RuntimeException e) {
            logger.error("Student {} cannot be deleted", student);
            throw new ServiceException("Not deleted: " + student, e);
        }
    }

    public List<Student> findAll() {
        logger.info("Staring to find all students");
        return dao.findAll().orElseThrow(() -> new ServiceException("All students not found"));
    }
}
