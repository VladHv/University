package ua.foxminded.herasimov.university.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.herasimov.university.dao.TeacherDao;
import ua.foxminded.herasimov.university.entity.Teacher;

import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    private SessionFactory sessionFactory;

    @Autowired
    public TeacherDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void create(Teacher entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }

    @Override
    @Transactional
    public Teacher findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }

    @Override
    @Transactional
    public void update(Teacher entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = session.get(Teacher.class, id);
        session.remove(teacher);
    }

    @Override
    @Transactional
    public void delete(Teacher entity) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(entity);
    }

    @Override
    @Transactional
    public List<Teacher> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Teacher t order by t.id").list();
    }
}
