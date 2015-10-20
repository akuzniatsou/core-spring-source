package org.epam.booking.repository;

import java.util.Collection;

/**
 * @author Andrei Kuzniatsou.
 */
public interface IBaseRepository<T> {

    void insert(T value);

    T read(int id);

    void delete(T value);

    void update(T value);

    Collection<T> readAll();
}
