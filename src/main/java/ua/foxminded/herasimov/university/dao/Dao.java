package ua.foxminded.herasimov.university.dao;

import java.util.List;

public interface Dao<K extends Number, T> {

    public void create(T entity);

    public T findById(K id);

    public void update(T entity);

    public void delete(K id);

    public void delete(T entity);

    public List<T> findAll();
}
