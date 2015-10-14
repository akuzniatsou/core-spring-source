package org.epam.university;

import org.epam.university.domain.Client;
import org.epam.university.domain.Event;
import org.epam.university.domain.EventType;
import org.epam.university.logger.IEventLogger;

import java.io.IOException;
import java.util.Map;

/**
 * @author Andrei Kuzniatsou
 */
public class App {

    private Client client;
    private IEventLogger eventLogger;
    private Map<EventType, IEventLogger> loggers;

    public App(Client client, IEventLogger eventLogger, Map<EventType, IEventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(EventType type, Event event) throws IOException {
        IEventLogger logger = loggers.get(type);
        if (null == logger) {
            logger = eventLogger;
        }
        String message = event.getMsg().replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        logger.logEvent(event);
    }
}
