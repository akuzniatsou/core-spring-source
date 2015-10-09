package org.epam.university.logger;

/**
 * @author Andrei Kuzniatsou
 */
public class ConsoleEventLogger implements IEventLogger {

    public void logEvent(String message) {
        System.out.println(message);
    }
}
