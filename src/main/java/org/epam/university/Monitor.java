package org.epam.university;

import org.epam.university.logger.IEventLogger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Andrei Kuzniatsou
 */
public class Monitor implements ApplicationListener {

    private IEventLogger logger;

    public IEventLogger getLogger() {
        return logger;
    }

    public void setLogger(IEventLogger logger) {
        this.logger = logger;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("monitor " + logger.getClass().getSimpleName());
    }

}
