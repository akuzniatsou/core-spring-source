package org.epam.booking.service;

import org.epam.booking.domain.Auditorium;
import org.epam.booking.domain.Event;
import org.epam.booking.domain.EventRating;

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
public interface IEventService {

    void create(String name, Date date, Double price, EventRating rating);

    void remove(Event event);

    Event getEventByName(String name);

    List<Event> getAllEvents();

    List<Event> getForDateRange(Date startDate, Date endDate);

    List<Event> getNextEvents(Date toDate);

    void assignAuditorium(Event event, Auditorium auditorium, Date date);
}
