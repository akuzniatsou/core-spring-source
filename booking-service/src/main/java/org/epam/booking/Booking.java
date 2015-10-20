package org.epam.booking;

import org.epam.booking.config.AppConfig;
import org.epam.booking.domain.EventRating;
import org.epam.booking.domain.User;
import org.epam.booking.repository.AuditoriumRepository;
import org.epam.booking.service.IAuditoriumService;
import org.epam.booking.service.IEventService;
import org.epam.booking.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;

/**
 * //TODO: [before commit] class description.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/14/15
 *
 * @author Andrei Kuzniatsou
 */
public class Booking {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        ApplicationContext context = new ClassPathXmlApplicationContext("org/epam/booking/spring.xml");

        prepareUsers(context);
        prepareEvents(context);



        AuditoriumRepository auditoruimRepository = context.getBean(AuditoriumRepository.class);
        System.out.println();

    }

    private static void prepareEvents(ApplicationContext context) {
        IEventService eventService = context.getBean(IEventService.class);
        eventService.create("Crimson Peak", Date.valueOf("2015-10-1"), 10.0, EventRating.HIGH);
        eventService.create("Tu Xia Chuan Qi: Qing Li Chuan Shuo", Date.valueOf("2015-10-2"), 5.0, EventRating.MID);
        eventService.create("The Martian", Date.valueOf("2015-10-3"), 11.0, EventRating.MID);
        eventService.create("Jungle Shuffle", Date.valueOf("2015-10-4"), 5.0, EventRating.MID);
        eventService.create("The Walk", Date.valueOf("2015-10-5"), 11.0, EventRating.HIGH);
        eventService.create("Rodina", Date.valueOf("2015-10-6"), 11.5, EventRating.LOW);


        System.out.println(eventService.getAllEvents());
        System.out.println(eventService.getEventByName("Crimson Peak"));
        System.out.println(eventService.getNextEvents(Date.valueOf("2015-10-4")));
        System.out.println(eventService.getForDateRange(Date.valueOf("2015-10-2"), Date.valueOf("2015-10-4")));



        IAuditoriumService auditoriumService = context.getBean(IAuditoriumService.class);


    }

    private static void prepareUsers(ApplicationContext context) {
        IUserService userService = context.getBean(IUserService.class);
        userService.register(new User("Andrei", "Kuzniatsou", "andrei_kuzniatsou@email.com", Date.valueOf("1983-8-20")));
        userService.register(new User("Dzmitry", "Kuzniatsou", "dzmitry_kuzniatsou@email.com", Date.valueOf("1986-4-1")));
        userService.register(new User("Dzmitry", "Marachou", "dzmitry_marachou@email.com", Date.valueOf("1985-12-11")));

//        System.out.println(userService.getUserById(1L));
//        System.out.println(userService.getUsersByName("Dzmitry"));
//        System.out.println(userService.getUserByEmail("dzmitry_kuzniatsou@email.com"));
    }


}
