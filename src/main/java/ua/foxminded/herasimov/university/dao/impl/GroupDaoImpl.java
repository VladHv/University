package ua.foxminded.herasimov.university.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.herasimov.university.dao.GroupDao;
import ua.foxminded.herasimov.university.entity.Group;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class GroupDaoImpl implements GroupDao {

    private SessionFactory sessionFactory;

    @Autowired
    public GroupDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Optional<Group> getGroupByStudentId(Integer studentId) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Group> query = session.createQuery("select s.group from Student s where s.id =:id", Group.class);
        query.setParameter("id", studentId);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    @Transactional
    public void create(Group entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }

    @Override
    @Transactional
    public Optional<Group> findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Group.class, id));
    }

    @Override
    @Transactional
    public void update(Group entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Group group = session.get(Group.class, id);
        session.remove(group);
    }

    @Override
    @Transactional
    public void delete(Group entity) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(entity);
    }

    @Override
    @Transactional
    public Optional<List<Group>> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.createQuery("select g from Group g order by g.id", Group.class).list());
    }
}
