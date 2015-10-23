package org.epam.booking.repository;

import org.epam.booking.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Andrei Kuzniatsou
 */
@Repository
public class UserRepository implements IBaseRepository<User> {

    private Map<Integer, User> userMap = new HashMap<>();
    private AtomicInteger userId = new AtomicInteger(1);


    @Override
    public void insert(User user) {
        user.setId(userId.getAndIncrement());
        userMap.put(user.getId(), user);
    }

    @Override
    public User read(int id) {
        return userMap.get(id);
    }

    @Override
    public void delete(User user) {
        userMap.remove(user.getId());
    }

    @Override
    public void update(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public Collection<User> readAll() {
        return userMap.values();
    }
}
