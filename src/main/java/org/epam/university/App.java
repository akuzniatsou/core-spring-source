package org.epam.university;

import org.epam.university.domain.Client;
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

    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }
}
