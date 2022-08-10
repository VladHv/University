package ua.foxminded.herasimov.university.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.foxminded.herasimov.university.dao.GroupDao;
import ua.foxminded.herasimov.university.entity.Group;

import java.util.List;

@Repository
public class GroupDaoImpl implements GroupDao {

    private SessionFactory sessionFactory;

    @Autowired
    public GroupDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Integer getGroupIdByStudentId(Integer studentId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createNativeQuery("SELECT group_id FROM students WHERE id = :id").addEntity(Group.class);
        query.setParameter("id", studentId);
        return (Integer) query.getSingleResult();
    }

    @Override
    public void create(Group entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }

    @Override
    public Group findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Group.class, id);
    }

    @Override
    public void update(Group entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Group group = session.get(Group.class, id);
        session.remove(group);
    }

    @Override
    public void delete(Group entity) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(entity);
    }

    @Override
    public List<Group> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Group g order by g.id").list();
    }
}
