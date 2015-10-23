package org.epam.booking.service.discount;

import org.epam.booking.domain.User;

/**
 * //TODO: [before commit] class description.
 * <p/>
 * Copyright (C) 2015 copyright.com
 * <p/>
 * Date: 10/14/15
 *
 * @author Andrei Kuzniatsou
 */
public interface IDiscountStrategy {

    Double getDiscount(User user);
}
