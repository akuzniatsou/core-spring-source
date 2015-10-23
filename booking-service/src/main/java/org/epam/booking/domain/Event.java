package org.epam.booking.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author Andrei Kuzniatsou
 */
public class Event extends BaseDomain {

    private String name;
    private Date eventDate;
    private Double basePrice;
    private EventRating rating;

    public Event(String name, Date eventDate, Double price, EventRating rating) {
        this.name = name;
        this.eventDate = eventDate;
        this.basePrice = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public EventRating getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Event rhs = (Event) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.name, rhs.name)
                .append(this.eventDate, rhs.eventDate)
                .append(this.basePrice, rhs.basePrice)
                .append(this.rating, rhs.rating)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(name)
                .append(eventDate)
                .append(basePrice)
                .append(rating)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("name", name)
                .append("eventDate", eventDate)
                .append("basePrice", basePrice)
                .append("rating", rating)
                .toString();
    }
}
