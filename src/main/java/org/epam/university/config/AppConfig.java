package org.epam.university.config;

import org.epam.university.domain.Client;
import org.epam.university.domain.Event;
import org.springframework.context.annotation.*;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Andrei Kuzniatsou
 */
@Configuration
@Import(LoggerConfig.class)
@ImportResource("classpath:org/epam/university/spring.xml")
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Event event() {
        Event event = new Event(new Date(), DateFormat.getDateTimeInstance());
        event.setMsg("Some event for user 1");
        return event;
    }

    @Bean
    public Client client() {
        return new Client();
    }

}
