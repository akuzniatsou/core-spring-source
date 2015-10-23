package org.epam.booking.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author Andrei Kuzniatsou
 */
public class Ticket extends BaseDomain {

    private int seatsNumber;
    private String eventName;
    private String auditoriumName;
    private Date eventDate;

    public Ticket(int seatsNumber, String eventName, String auditoriumName, Date eventDate) {
        this.seatsNumber = seatsNumber;
        this.eventName = eventName;
        this.auditoriumName = auditoriumName;
        this.eventDate = eventDate;
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
        Ticket rhs = (Ticket) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.seatsNumber, rhs.seatsNumber)
                .append(this.eventName, rhs.eventName)
                .append(this.auditoriumName, rhs.auditoriumName)
                .append(this.eventDate, rhs.eventDate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(seatsNumber)
                .append(eventName)
                .append(auditoriumName)
                .append(eventDate)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("seatsNumber", seatsNumber)
                .append("eventName", eventName)
                .append("auditoriumName", auditoriumName)
                .append("eventDate", eventDate)
                .toString();
    }
}
