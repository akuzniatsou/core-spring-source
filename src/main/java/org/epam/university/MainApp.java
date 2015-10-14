package org.epam.university;

import org.epam.university.domain.Event;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author Andrei Kuzniatsou
 */
public class MainApp {

    public static void main(String[] args) throws InterruptedException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/epam/university/spring.xml");

        App app = context.getBean(App.class);

        for (int i = 0; i < 10; i++) {
            app.logEvent(context.getBean(Event.class));
            Thread.sleep(1000);
        }

    }
}
