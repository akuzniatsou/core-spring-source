package org.epam.booking.service;

import org.epam.booking.domain.Ticket;
import org.epam.booking.domain.User;

import java.util.List;

/**
 * @author Andrei Kuzniatsou
 */
public interface IUserService {

    void register(User user);
    void remove(User user);
    User getUserById(int id);
    User getUserByEmail(String email);
    List<User> getUsersByName(String name);
    List<Ticket> getBookedTickets(User user);


}
