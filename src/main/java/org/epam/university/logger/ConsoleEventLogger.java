package org.epam.university.logger;

import org.epam.university.domain.Event;

/**
 * @author Andrei Kuzniatsou
 */
public class ConsoleEventLogger implements IEventLogger {

    public void logEvent(String message) {
        System.out.println(message);
    }

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
