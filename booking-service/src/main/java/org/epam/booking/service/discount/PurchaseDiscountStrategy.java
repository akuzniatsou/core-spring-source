package org.epam.booking.service.discount;

import org.epam.booking.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author Andrei Kuzniatsou
 */
@Component
public class PurchaseDiscountStrategy implements IDiscountStrategy {

    @Override
    public Double getDiscount(User user) {
        return 50.0;
    }
}
