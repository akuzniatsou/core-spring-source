package org.epam.booking.service;

import org.epam.booking.domain.Auditorium;

import java.util.Collection;
import java.util.List;

/**
 * @author Andrei Kuzniatsou
 */
public interface IAuditoriumService {

    Collection<Auditorium> getAuditoriums();

    int getSeatsNumber(String name);

    List<Integer> getVipSeatsNumber(String name);
}
