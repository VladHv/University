package ua.foxminded.herasimov.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.impl.GroupDaoImpl;
import ua.foxminded.herasimov.university.dao.impl.TimetableDaoImpl;
import ua.foxminded.herasimov.university.entity.Timetable;
import ua.foxminded.herasimov.university.exception.ServiceException;
import ua.foxminded.herasimov.university.service.TimetableService;

import java.util.List;
import java.util.Optional;

@Service
public class TimetableServiceImpl implements TimetableService {
    private static final Logger logger = LoggerFactory.getLogger(TimetableServiceImpl.class);
    private final TimetableDaoImpl timetableDao;

    @Autowired
    public TimetableServiceImpl(TimetableDaoImpl timetableDao) {
        this.timetableDao = timetableDao;
    }

    public int create(Timetable timetable) {
        logger.info("Starting create: {}", timetable);
        try {
            return timetableDao.create(timetable);
        } catch (DataAccessException e) {
            logger.error("Timetable {} cannot be found", timetable);
            throw new ServiceException("Not created: " + timetable.toString(), e);
        }
    }

    public Optional<Timetable> findById(Integer id) {
        logger.info("Finding timetable by id: {}", id);
        try {
            return Optional.ofNullable(timetableDao.findById(id));
        } catch (DataAccessException e) {
            logger.error("Timetable with id '{}' cannot be found", id);
            throw new ServiceException("Timetable not found by id: " + id, e);
        }
    }

    public int update(Timetable timetable) {
        logger.info("Updating timetable {}", timetable);
        try {
            return timetableDao.update(timetable);
        } catch (DataAccessException e) {
            logger.error("Timetable {} cannot be updated", timetable);
            throw new ServiceException("Not updated: " + timetable, e);
        }
    }

    public int delete(Integer id) {
        logger.info("Deleting timetable by id: {}", id);
        try {
            return timetableDao.delete(id);
        } catch (DataAccessException e) {
            logger.error("Timetable with id '{}' cannot be deleted", id);
            throw new ServiceException("Timetable by id: " + id + " not deleted", e);
        }
    }

    public int delete(Timetable timetable) {
        logger.info("Deleting timetable: {}", timetable);
        try {
            return timetableDao.delete(timetable);
        } catch (DataAccessException e) {
            logger.error("Timetable {} cannot be deleted", timetable);
            throw new ServiceException("Not deleted: " + timetable, e);
        }
    }

    public Optional<List<Timetable>> findAll() {
        logger.info("Staring to find all timetables");
        try {
            return Optional.ofNullable(timetableDao.findAll());
        } catch (DataAccessException e) {
            logger.info("All timetables not found");
            throw new ServiceException("All timetables not found", e);
        }
    }

}
