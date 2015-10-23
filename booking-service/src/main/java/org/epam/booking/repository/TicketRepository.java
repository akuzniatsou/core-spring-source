package org.epam.booking.repository;

import org.epam.booking.domain.Ticket;
import org.epam.booking.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author Andrei Kuzniatsou
 */
@Repository
public class TicketRepository implements IBaseRepository<Ticket> {

    private Map<Integer, Ticket> ticketMap = new HashMap<>();
    private Map<Integer, List<Integer>> userToTickets = new HashMap<>();


    @Override
    public void insert(Ticket ticket) {
        ticketMap.put(ticket.getId(), ticket);
    }

    @Override
    public Ticket read(int id) {
        return ticketMap.get(id);
    }

    @Override
    public void delete(Ticket ticket) {
        ticketMap.remove(ticket.getId());
    }

    @Override
    public void update(Ticket ticket) {
        ticketMap.put(ticket.getId(), ticket);
    }

    @Override
    public Collection<Ticket> readAll() {
        return ticketMap.values();
    }

    public List<Ticket> getTickets(User user) {
        List<Integer> ticketIds = userToTickets.get(user.getId());
        List<Ticket> tickets = new ArrayList<>();
        for (Integer id : ticketIds) {
            tickets.add(read(id));
        }
        return tickets;
    }


}
