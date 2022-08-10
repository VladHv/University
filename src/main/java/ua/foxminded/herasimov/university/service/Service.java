package ua.foxminded.herasimov.university.service;

import java.util.List;
import java.util.Optional;

public interface Service<K extends Number, T> {

    void create(T entity);

    Optional<T> findById(K id);

    void update(T entity);

    void delete(K id);

    void delete(T entity);

    Optional<List<T>> findAll();
}
