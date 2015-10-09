package org.epam.university;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Andrei Kuzniatsou
 */
public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("org.epam.university/spring.xml");

        App app = context.getBean(App.class);

        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");
    }
}
