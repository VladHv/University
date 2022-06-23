package ua.foxminded.herasimov.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.impl.TeacherDaoImpl;
import ua.foxminded.herasimov.university.entity.Teacher;

import java.util.List;

@Service
public class TeacherService {

    private TeacherDaoImpl dao;

    @Autowired
    public TeacherService(TeacherDaoImpl dao) {
        this.dao = dao;
    }

    public int create(Teacher teacher) {
        return dao.create(teacher);
    }

    public Teacher findById(Integer id) {
        return dao.findById(id);
    }

    public int update(Teacher teacher) {
        return dao.update(teacher);
    }

    public int delete(Teacher teacher) {
        return dao.delete(teacher);
    }

    public int delete(Integer id) {
        return dao.delete(id);
    }

    public List<Teacher> findAll() {
        return dao.findAll();
    }
}
