package ua.foxminded.herasimov.university.dao;

import java.util.List;

public interface Dao<K extends Number, T> {

    void create(T entity);

    T findById(K id);

    void update(T entity);

    void delete(K id);

    void delete(T entity);

    List<T> findAll();
}
