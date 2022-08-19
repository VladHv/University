package ua.foxminded.herasimov.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.LessonDao;
import ua.foxminded.herasimov.university.entity.Lesson;
import ua.foxminded.herasimov.university.exception.ServiceException;
import ua.foxminded.herasimov.university.service.LessonService;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private static final Logger logger = LoggerFactory.getLogger(LessonServiceImpl.class);
    private LessonDao dao;

    @Autowired
    public LessonServiceImpl(LessonDao dao) {
        this.dao = dao;
    }

    public void create(Lesson lesson) {
        logger.info("Starting create: {}", lesson);
        try {
            dao.create(lesson);
        } catch (RuntimeException e) {
            logger.error("Lesson {} cannot be found", lesson);
            throw new ServiceException("Not created: " + lesson.toString(), e);
        }
    }

    public Lesson findById(Integer id) {
        logger.info("Finding lesson by id: {}", id);
        return dao.findById(id).orElseThrow(() -> new ServiceException("Lesson not found by id: " + id));
    }

    public void update(Lesson lesson) {
        logger.info("Updating lesson {}", lesson);
        try {
            dao.update(lesson);
        } catch (RuntimeException e) {
            logger.error("Lesson {} cannot be updated", lesson);
            throw new ServiceException("Not updated: " + lesson, e);
        }
    }

    public void delete(Integer id) {
        logger.info("Deleting lesson by id: {}", id);
        try {
            dao.delete(id);
        } catch (RuntimeException e) {
            logger.error("Lesson with id '{}' cannot be deleted", id);
            throw new ServiceException("Lesson by id: " + id + " not deleted", e);
        }
    }

    public void delete(Lesson lesson) {
        logger.info("Deleting lesson: {}", lesson);
        try {
            dao.delete(lesson);
        } catch (RuntimeException e) {
            logger.error("Lesson {} cannot be deleted", lesson);
            throw new ServiceException("Not deleted: " + lesson, e);
        }
    }

    public List<Lesson> findAll() {
        logger.info("Staring to find all lessons");
        return dao.findAll().orElseThrow(() -> new ServiceException("All lessons not found"));
    }
}
