package org.epam.booking.service;

import org.epam.booking.domain.Auditorium;
import org.epam.booking.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Andrei Kuzniatsou
 */
@Service
public class AuditoriumService implements IAuditoriumService {

    @Autowired
    private AuditoriumRepository auditoruimRepository;

    @Override
    public Collection<Auditorium> getAuditoriums() {
        return auditoruimRepository.readAll();
    }

    @Override
    public int getSeatsNumber(String name) {
        for (Auditorium auditorium : auditoruimRepository.readAll()) {
            if (auditorium.getName().equals(name)) {
                return auditorium.getSeatsNumber();
            }
        }
        return 0;
    }

    @Override
    public List<Integer> getVipSeatsNumber(String name) {
        for (Auditorium auditorium : auditoruimRepository.readAll()) {
            if (auditorium.getName().equals(name)) {
                return auditorium.getVipSeats();
            }
        }
        return Collections.emptyList();
    }
}
