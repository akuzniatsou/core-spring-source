package org.epam.university;

import org.epam.university.domain.Client;
import org.epam.university.domain.Event;
import org.epam.university.logger.IEventLogger;

/**
 * @author Andrei Kuzniatsou
 */
public class App {

    private Client client;
    private IEventLogger eventLogger;

    public App(Client client, IEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(Event event) {
        String message = event.getMsg().replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}
