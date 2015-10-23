package org.epam.booking.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * //TODO: [before commit] class description.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/14/15
 *
 * @author Andrei Kuzniatsou
 */
@Configuration
@ImportResource("classpath:org/epam/booking/spring.xml")
@ComponentScan("org.epam.booking")
public class AppConfig {
}
