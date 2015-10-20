package org.epam.booking.service;

import org.epam.booking.domain.Event;
import org.epam.booking.domain.Ticket;
import org.epam.booking.domain.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Andrei Kuzniatsou
 */
public class BookingService implements IBookingService {

    private static final Logger LOGGER = Logger.getLogger(BookingService.class.getSimpleName());
    @Autowired
    private EventService eventService;

    private Map<Integer, List<Ticket>> purchasedTickets = new HashMap<>();

    @Override
    public Double getTicketPrice(Event event, Date date, DateTime time, int seats, User user) {
        return null;
    }

    @Override
    public boolean bookTickets(User user, Ticket ticket) {
        List<Ticket> tickets = purchasedTickets.get(user);
        if (!tickets.contains(ticket)) {
            tickets.add(ticket);
        }
        return false;
    }

    @Override
    public List<Ticket> getTicketsForEvent(Event event, Date date) {
//        Map<Date, Map<Auditorium, Event>> assignedEvents = eventService.getAssignedEvents();
//        Map<Auditorium, Event> auditoriumEventMap = assignedEvents.get(date);
//        if (auditoriumEventMap.isEmpty()) {
//            LOGGER.warning("Event is not existed");
//        } else {
//
//        }
        return null;
    }
}
