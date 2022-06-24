package ua.foxminded.herasimov.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.foxminded.herasimov.university.dao.impl.StudentDaoImpl;
import ua.foxminded.herasimov.university.entity.Student;
import ua.foxminded.herasimov.university.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDaoImpl dao;

    @Autowired
    public StudentServiceImpl(StudentDaoImpl dao) {
        this.dao = dao;
    }

    public int create(Student student) {
        return dao.create(student);
    }

    public Student findById(Integer id) {
        return dao.findById(id);
    }

    public int update(Student student) {
        return dao.update(student);
    }

    public int delete(Integer id) {
        return dao.delete(id);
    }

    public int delete(Student student) {
        return dao.delete(student);
    }

    public List<Student> findAll() {
        return dao.findAll();
    }
}
