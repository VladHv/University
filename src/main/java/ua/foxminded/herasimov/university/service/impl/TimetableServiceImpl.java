package ua.foxminded.herasimov.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.TimetableDao;
import ua.foxminded.herasimov.university.entity.Timetable;
import ua.foxminded.herasimov.university.exception.ServiceException;
import ua.foxminded.herasimov.university.service.TimetableService;

import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {
    private static final Logger logger = LoggerFactory.getLogger(TimetableServiceImpl.class);
    private final TimetableDao timetableDao;

    @Autowired
    public TimetableServiceImpl(TimetableDao timetableDao) {
        this.timetableDao = timetableDao;
    }

    public void create(Timetable timetable) {
        logger.info("Starting create: {}", timetable);
        try {
            timetableDao.create(timetable);
        } catch (RuntimeException e) {
            logger.error("Timetable {} cannot be found", timetable);
            throw new ServiceException("Not created: " + timetable.toString(), e);
        }
    }

    public Timetable findById(Integer id) {
        logger.info("Finding timetable by id: {}", id);
        return timetableDao.findById(id).orElseThrow(() -> new ServiceException("Timetable not found by id: " + id));
    }

    public void update(Timetable timetable) {
        logger.info("Updating timetable {}", timetable);
        try {
            timetableDao.update(timetable);
        } catch (RuntimeException e) {
            logger.error("Timetable {} cannot be updated", timetable);
            throw new ServiceException("Not updated: " + timetable, e);
        }
    }

    public void delete(Integer id) {
        logger.info("Deleting timetable by id: {}", id);
        try {
            timetableDao.delete(id);
        } catch (RuntimeException e) {
            logger.error("Timetable with id '{}' cannot be deleted", id);
            throw new ServiceException("Timetable by id: " + id + " not deleted", e);
        }
    }

    public void delete(Timetable timetable) {
        logger.info("Deleting timetable: {}", timetable);
        try {
            timetableDao.delete(timetable);
        } catch (RuntimeException e) {
            logger.error("Timetable {} cannot be deleted", timetable);
            throw new ServiceException("Not deleted: " + timetable, e);
        }
    }

    public List<Timetable> findAll() {
        logger.info("Staring to find all timetables");
        return timetableDao.findAll().orElseThrow(() -> new ServiceException("All timetables not found"));
    }

}
