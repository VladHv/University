package ua.foxminded.herasimov.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.impl.TimetableDaoImpl;
import ua.foxminded.herasimov.university.entity.Timetable;

import java.util.List;

@Service
public class TimetableService {

    private final TimetableDaoImpl dao;

    @Autowired
    public TimetableService(TimetableDaoImpl dao) {
        this.dao = dao;
    }

    public int create(Timetable timetable) {
        return dao.create(timetable);
    }

    public Timetable findById(Integer id) {
        return dao.findById(id);
    }

    public void update(Timetable timetable) {
        dao.update(timetable);
    }

    public void delete(Integer id) {
        dao.delete(id);
    }

    public void delete(Timetable timetable) {
        dao.delete(timetable);
    }

    public List<Timetable> findAll() {
        return dao.findAll();
    }



}
