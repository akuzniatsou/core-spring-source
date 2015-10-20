package org.epam.booking.service;

import org.epam.booking.domain.Auditorium;
import org.epam.booking.domain.Event;
import org.epam.booking.domain.EventRating;
import org.epam.booking.repository.AuditoriumRepository;
import org.epam.booking.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Andrei Kuzniatsou
 */
@Service
public class EventService implements IEventService {

    private static final Logger LOGGER = Logger.getLogger(EventService.class.getSimpleName());

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AuditoriumRepository auditoriumRepository;



    @Override
    public void create(String name, Date date, Double price, EventRating rating) {
        eventRepository.insert(new Event(name, date, price, rating));
    }

    @Override
    public void remove(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public Event getEventByName(String name) {
        for (Event event : eventRepository.readAll()) {
            if (event.getName().equals(name)) {
                return event;
            }
        }
        return null;
    }

    @Override
    public List<Event> getAllEvents() {
        return null;
    }

    @Override
    public List<Event> getForDateRange(Date startDate, Date endDate) {
        List<Event> eventsBetween = new ArrayList<>();
        for (Event event : eventRepository.readAll()) {
            Date date = event.getEventDate();
            if (date.after(startDate) && date.before(endDate)) {
                eventsBetween.add(event);
            }
        }
        return eventsBetween;
    }

    @Override
    public List<Event> getNextEvents(Date toDate) {
        List<Event> eventsAfter = new ArrayList<>();
        for (Event event : eventRepository.readAll()) {
            Date date = event.getEventDate();
            if (date.after(toDate)) {
                eventsAfter.add(event);
            }
        }
        return eventsAfter;
    }

    @Override
    public void assignAuditorium(final Event event, final Auditorium auditorium, Date date) {
//        Map<Auditorium, Event> map = assigneadEvents.get(date);
//        if (!CollectionUtils.isEmpty(map)) {
//            for (Map.Entry<Auditorium, Event> entry : map.entrySet()) {
//                if (entry.getKey().equals(auditorium)) {
//                    LOGGER.warning("Event can not be assigned for this date");
//                    return;
//                }
//            }
//        }
//        assignedEvents.put(date, new HashMap<Auditorium, Event>(){{put(auditorium, event);}});
    }
}
