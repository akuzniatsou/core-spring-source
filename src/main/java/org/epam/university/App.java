package org.epam.university;

import org.epam.university.domain.Client;
import org.epam.university.logger.ConsoleEventLogger;

/**
 * @author Andrei Kuzniatsou
 */
public class App {

    private Client client;
    private ConsoleEventLogger eventLogger;

    public static void main(String[] args) {
        App app = new App();

        app.client = new Client("1", "John Smith");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("Some event for user 1");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }
}
