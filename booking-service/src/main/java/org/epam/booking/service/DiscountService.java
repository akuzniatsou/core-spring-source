package org.epam.booking.service;

import org.epam.booking.domain.Event;
import org.epam.booking.domain.User;
import org.epam.booking.service.discount.IDiscountStrategy;

import java.util.Date;
import java.util.List;

/**
 * @author Andrei Kuzniatsou
 */
public class DiscountService implements IDiscountService {

    private List<IDiscountStrategy> discountStrategies;

    @Override
    public Double getDiscount(User user, Event event, Date date) {
        Double totalDiscount = 0.0;
        for (IDiscountStrategy discountStrategy : discountStrategies) {
            totalDiscount += discountStrategy.getDiscount(user);
        }
        return totalDiscount;
    }
}
