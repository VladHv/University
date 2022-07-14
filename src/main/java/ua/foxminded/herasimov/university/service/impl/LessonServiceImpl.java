package ua.foxminded.herasimov.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.impl.LessonDaoImpl;
import ua.foxminded.herasimov.university.entity.Lesson;
import ua.foxminded.herasimov.university.exception.ServiceException;
import ua.foxminded.herasimov.university.service.LessonService;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {

    private static final Logger logger = LoggerFactory.getLogger(LessonServiceImpl.class);
    private LessonDaoImpl dao;

    @Autowired
    public LessonServiceImpl(LessonDaoImpl dao) {
        this.dao = dao;
    }

    public int create(Lesson lesson) {
        logger.info("Starting create: {}", lesson);
        try {
            return dao.create(lesson);
        } catch (DataAccessException e) {
            logger.error("Lesson {} cannot be found", lesson);
            throw new ServiceException("Not created: " + lesson.toString(), e);
        }
    }

    public Optional<Lesson> findById(Integer id) {
        logger.info("Finding lesson by id: {}", id);
        try {
            return Optional.ofNullable(dao.findById(id));
        } catch (DataAccessException e) {
            logger.error("Lesson with id '{}' cannot be found", id);
            throw new ServiceException("Lesson not found by id: " + id, e);
        }
    }

    public int update(Lesson lesson) {
        logger.info("Updating lesson {}", lesson);
        try {
            return dao.update(lesson);
        } catch (DataAccessException e) {
            logger.error("Lesson {} cannot be updated", lesson);
            throw new ServiceException("Not updated: " + lesson, e);
        }
    }

    public int delete(Integer id) {
        logger.info("Deleting lesson by id: {}", id);
        try {
            return dao.delete(id);
        } catch (DataAccessException e) {
            logger.error("Lesson with id '{}' cannot be deleted", id);
            throw new ServiceException("Lesson by id: " + id + " not deleted", e);
        }
    }

    public int delete(Lesson lesson) {
        logger.info("Deleting lesson: {}", lesson);
        try {
            return dao.delete(lesson);
        } catch (DataAccessException e) {
            logger.error("Lesson {} cannot be deleted", lesson);
            throw new ServiceException("Not deleted: " + lesson, e);
        }
    }

    public Optional<List<Lesson>> findAll() {
        logger.info("Staring to find all lessons");
        try {
            return Optional.ofNullable(dao.findAll());
        } catch (DataAccessException e) {
            logger.info("All lessons not found");
            throw new ServiceException("All lessons not found", e);
        }
    }
}
