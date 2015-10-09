package org.epam.university.logger;

import org.epam.university.domain.Event;

/**
 * @author Andrei Kuzniatsou
 */
public interface IEventLogger {

    void logEvent(Event event);

    void logEvent(String message);
}
