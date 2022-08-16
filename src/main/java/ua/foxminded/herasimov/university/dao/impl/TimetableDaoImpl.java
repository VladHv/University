package ua.foxminded.herasimov.university.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.herasimov.university.dao.TimetableDao;
import ua.foxminded.herasimov.university.entity.Timetable;

import java.util.List;

@Repository
public class TimetableDaoImpl implements TimetableDao {

    private SessionFactory sessionFactory;

    @Autowired
    public TimetableDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void create(Timetable entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }

    @Override
    @Transactional
    public Timetable findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Timetable.class, id);
    }

    @Override
    @Transactional
    public void update(Timetable entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Timetable timetable = session.get(Timetable.class, id);
        session.remove(timetable);
    }

    @Override
    @Transactional
    public void delete(Timetable entity) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(entity);
    }

    @Override
    @Transactional
    public List<Timetable> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable t order by t.id").list();
    }
}
