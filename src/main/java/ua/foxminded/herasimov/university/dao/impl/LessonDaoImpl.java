package ua.foxminded.herasimov.university.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.herasimov.university.dao.LessonDao;
import ua.foxminded.herasimov.university.entity.Lesson;

import java.util.List;
import java.util.Optional;

@Repository
public class LessonDaoImpl implements LessonDao {

    private SessionFactory sessionFactory;

    @Autowired
    public LessonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void create(Lesson entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }

    @Override
    @Transactional
    public Optional<Lesson> findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Lesson.class, id));
    }

    @Override
    @Transactional
    public void update(Lesson entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Lesson lesson = session.get(Lesson.class, id);
        session.remove(lesson);
    }

    @Override
    @Transactional
    public void delete(Lesson entity) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(entity);
    }

    @Override
    @Transactional
    public Optional<List<Lesson>> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.createQuery("select l from Lesson l order by l.id", Lesson.class).list());
    }
}
