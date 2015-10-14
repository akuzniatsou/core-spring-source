package org.epam.university;

import org.epam.university.config.AppConfig;
import org.epam.university.domain.Event;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author Andrei Kuzniatsou
 */
public class MainApp {

    public static void main(String[] args) throws InterruptedException, IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        App app = context.getBean(App.class);

        for (int i = 0; i < 10; i++) {
            app.logEvent(null, context.getBean(Event.class));
            Thread.sleep(1000);
        }

    }
}
