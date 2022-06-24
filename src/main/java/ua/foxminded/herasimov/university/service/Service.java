package ua.foxminded.herasimov.university.service;

import java.util.List;

public interface Service<K extends Number, T> {

    int create(T entity);

    T findById(K id);

    int update(T entity);

    int delete(K id);

    int delete(T entity);

    List<T> findAll();
}
