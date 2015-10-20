package org.epam.booking.service;

import org.epam.booking.domain.Event;
import org.epam.booking.domain.Ticket;
import org.epam.booking.domain.User;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;

/**
 * //TODO: [before commit] class description.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/14/15
 *
 * @author Andrei Kuzniatsou
 */
public interface IBookingService {

    Double getTicketPrice(Event event, Date date, DateTime time, int seats, User user);

    boolean bookTickets(User user, Ticket ticket);

    List<Ticket> getTicketsForEvent(Event event, Date date);
}
