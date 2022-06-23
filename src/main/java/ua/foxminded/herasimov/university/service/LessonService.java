package ua.foxminded.herasimov.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.impl.LessonDaoImpl;
import ua.foxminded.herasimov.university.entity.Lesson;

import java.util.List;

@Service
public class LessonService {

    private LessonDaoImpl dao;

    @Autowired
    public LessonService(LessonDaoImpl dao) {
        this.dao = dao;
    }

    public int create(Lesson lesson) {
        return dao.create(lesson);
    }

    public Lesson findById(Integer id) {
        return dao.findById(id);
    }

    public int update(Lesson lesson) {
        return dao.update(lesson);
    }

    public int delete(Integer id) {
        return dao.delete(id);
    }

    public int delete(Lesson lesson) {
        return dao.delete(lesson);
    }

    public List<Lesson> findAll() {
        return dao.findAll();
    }
}
