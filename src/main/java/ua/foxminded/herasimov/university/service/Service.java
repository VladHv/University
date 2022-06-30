package ua.foxminded.herasimov.university.service;

import java.util.List;
import java.util.Optional;

public interface Service<K extends Number, T> {

    int create(T entity);

    Optional<T> findById(K id);

    int update(T entity);

    int delete(K id);

    int delete(T entity);

    Optional<List<T>> findAll();
}
