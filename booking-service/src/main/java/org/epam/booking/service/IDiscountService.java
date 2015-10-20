package org.epam.booking.service;

import org.epam.booking.domain.Event;
import org.epam.booking.domain.User;

import java.util.Date;

/**
 * //TODO Add description.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/14/2015
 *
 * @author Andrei Kuzniatsou
 */
public interface IDiscountService {

    Double getDiscount(User user, Event event, Date date);

}
