package org.epam.university;

import org.epam.university.domain.Client;
import org.epam.university.domain.Event;
import org.epam.university.domain.EventType;
import org.epam.university.logger.IEventLogger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * @author Andrei Kuzniatsou
 */
public class App {

    @Autowired
    private Client client;
    @Resource(name = "consoleEventLogger")
    private IEventLogger eventLogger;
    @Resource(name = "loggerMap")
    private Map<EventType, IEventLogger> loggers;

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
