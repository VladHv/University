package ua.foxminded.herasimov.university.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.foxminded.herasimov.university.dao.LessonDao;
import ua.foxminded.herasimov.university.entity.Lesson;

import java.util.List;

@Repository
public class LessonDaoImpl implements LessonDao {

    private SessionFactory sessionFactory;

    @Autowired
    public LessonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Lesson entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }

    @Override
    public Lesson findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Lesson.class, id);
    }

    @Override
    public void update(Lesson entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Lesson lesson = session.get(Lesson.class, id);
        session.remove(lesson);
    }

    @Override
    public void delete(Lesson entity) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(entity);
    }

    @Override
    public List<Lesson> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Lesson l order by l.id").list();
    }
}
