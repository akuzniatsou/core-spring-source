package org.epam.booking.repository;

import org.epam.booking.domain.Auditorium;
import org.epam.booking.domain.Event;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Andrei Kuzniatsou
 */
@Repository
public class EventRepository implements IBaseRepository<Event> {

    private Map<Integer, Event> eventMap = new HashMap<>();

    private Map<Integer, Auditorium> auditoriumMap = new HashMap<>();

    private AtomicInteger eventId = new AtomicInteger(1);


    @Override
    public void insert(Event event) {
        event.setId(eventId.getAndIncrement());
        eventMap.put(event.getId(), event);
    }

    @Override
    public Event read(int id) {
        return eventMap.get(id);
    }

    @Override
    public void delete(Event event) {
        eventMap.remove(event.getId());
    }

    @Override
    public void update(Event event) {
        eventMap.put(event.getId(), event);
    }

    @Override
    public Collection<Event> readAll() {
        return eventMap.values();
    }

    public void assignAuditorium(Event event, Auditorium auditorium) {
        auditoriumMap.put(event.getId(), auditorium);
    }
}
