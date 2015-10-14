package org.epam.university.logger;

import org.epam.university.domain.Event;

import java.io.IOException;
import java.util.List;

/**
 * @author Andrei Kuzniatsou
 */
public class CombineEventLogger implements IEventLogger {

    private List<IEventLogger> loggers;

    public CombineEventLogger(List<IEventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(String message) {
        System.out.println(message);
    }

    public void logEvent(Event event) throws IOException {
        for (IEventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
