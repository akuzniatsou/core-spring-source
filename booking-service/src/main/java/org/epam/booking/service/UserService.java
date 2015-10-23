package org.epam.booking.service;

import org.epam.booking.domain.Ticket;
import org.epam.booking.domain.User;
import org.epam.booking.repository.TicketRepository;
import org.epam.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Andrei Kuzniatsou
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getSimpleName());


    @Override
    public void register(User user) {
        if (getUserByEmail(user.getEmail()) == null) {
            userRepository.insert(user);
        } else {
            LOGGER.warning("User already exists");
        }
    }

    @Override
    public void remove(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.read(id);
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : userRepository.readAll()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsersByName(String name) {
        List<User> usersByName = new ArrayList<>();
        for (User user : userRepository.readAll()) {
            if (user.getName().equals(name)) {
                usersByName.add(user);
            }
        }
        return usersByName;
    }

    @Override
    public List<Ticket> getBookedTickets(User user) {
        return ticketRepository.getTickets(user);
    }
}
