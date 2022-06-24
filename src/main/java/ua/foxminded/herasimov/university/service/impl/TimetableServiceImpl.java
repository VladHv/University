package ua.foxminded.herasimov.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.impl.TimetableDaoImpl;
import ua.foxminded.herasimov.university.entity.Timetable;
import ua.foxminded.herasimov.university.service.TimetableService;

import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {

    private final TimetableDaoImpl dao;

    @Autowired
    public TimetableServiceImpl(TimetableDaoImpl dao) {
        this.dao = dao;
    }

    public int create(Timetable timetable) {
        return dao.create(timetable);
    }

    public Timetable findById(Integer id) {
        return dao.findById(id);
    }

    public int update(Timetable timetable) {
        return dao.update(timetable);
    }

    public int delete(Integer id) {
        return dao.delete(id);
    }

    public int delete(Timetable timetable) {
        return dao.delete(timetable);
    }

    public List<Timetable> findAll() {
        return dao.findAll();
    }


}
