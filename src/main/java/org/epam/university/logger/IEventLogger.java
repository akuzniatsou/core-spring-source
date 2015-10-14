package org.epam.university.logger;

import org.epam.university.domain.Event;

import java.io.IOException;

/**
 * @author Andrei Kuzniatsou
 */
public interface IEventLogger {

    void logEvent(Event event) throws IOException;

    void logEvent(String message);
}
