package ua.foxminded.herasimov.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.impl.GroupDaoImpl;
import ua.foxminded.herasimov.university.dao.impl.TimetableDaoImpl;
import ua.foxminded.herasimov.university.entity.Timetable;
import ua.foxminded.herasimov.university.exception.ServiceException;
import ua.foxminded.herasimov.university.service.TimetableService;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TimetableServiceImpl implements TimetableService {
    private static final Logger logger = LoggerFactory.getLogger(TimetableServiceImpl.class);
    private final TimetableDaoImpl timetableDao;
    private final GroupDaoImpl groupDao;

    @Autowired
    public TimetableServiceImpl(TimetableDaoImpl timetableDao, GroupDaoImpl groupDao) {
        this.timetableDao = timetableDao;
        this.groupDao = groupDao;
    }

    public int create(Timetable timetable) {
        logger.info("Starting create: {}", timetable);
        try {
            return timetableDao.create(timetable);
        } catch (RuntimeException e) {
            logger.error("Timetable {} cannot be found", timetable);
            throw new ServiceException("Not created: " + timetable.toString(), e);
        }
    }

    public Optional<Timetable> findById(Integer id) {
        logger.info("Finding timetable by id: {}", id);
        try {
            return Optional.ofNullable(timetableDao.findById(id));
        } catch (RuntimeException e) {
            logger.error("Timetable with id '{}' cannot be found", id);
            throw new ServiceException("Timetable not found by id: " + id, e);
        }
    }

    public int update(Timetable timetable) {
        logger.info("Updating timetable {}", timetable);
        try {
            return timetableDao.update(timetable);
        } catch (RuntimeException e) {
            logger.error("Timetable {} cannot be updated", timetable);
            throw new ServiceException("Not updated: " + timetable, e);
        }
    }

    public int delete(Integer id) {
        logger.info("Deleting timetable by id: {}", id);
        try {
            return timetableDao.delete(id);
        } catch (RuntimeException e) {
            logger.error("Timetable with id '{}' cannot be deleted", id);
            throw new ServiceException("Timetable by id: " + id + " not deleted", e);
        }
    }

    public int delete(Timetable timetable) {
        logger.info("Deleting timetable: {}", timetable);
        try {
            return timetableDao.delete(timetable);
        } catch (RuntimeException e) {
            logger.error("Timetable {} cannot be deleted", timetable);
            throw new ServiceException("Not deleted: " + timetable, e);
        }
    }

    public Optional<List<Timetable>> findAll() {
        logger.info("Staring to find all timetables");
        try {
            return Optional.ofNullable(timetableDao.findAll());
        } catch (RuntimeException e) {
            logger.info("All timetables not found");
            throw new ServiceException("All timetables not found", e);
        }
    }


    @Override
    public List<Timetable> getTeacherTimetableForDay(Integer teacherId, DayOfWeek day) {
        return timetableDao.findAll().stream()
                           .filter(t -> t.getTeacherId().equals(teacherId))
                           .filter(t -> t.getDay().equals(day.getValue()))
                           .collect(Collectors.toList());
    }

    @Override
    public List<Timetable> getTeacherTimetableForMonth(Integer teacherId) {
        return timetableDao.findAll().stream()
                           .filter(t -> t.getTeacherId().equals(teacherId))
                           .collect(Collectors.toList());
    }

    @Override
    public List<Timetable> getStudentTimetableForDay(Integer studentId, DayOfWeek day) {
        return timetableDao.findAll().stream()
                           .filter(t -> t.getGroupId().equals(groupDao.getGroupIdByStudentId(studentId)))
                           .filter(t -> t.getDay().equals(day.getValue()))
                           .collect(Collectors.toList());
    }

    @Override
    public List<Timetable> getStudentTimetableForMonth(Integer studentId) {
        return timetableDao.findAll().stream()
                           .filter(t -> t.getGroupId().equals(groupDao.getGroupIdByStudentId(studentId)))
                           .collect(Collectors.toList());
    }

}
