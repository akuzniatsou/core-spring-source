package org.epam.booking.repository;

import org.epam.booking.domain.Auditorium;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;

/**
 * @author Andrei Kuzniatsou
 */
@Repository
public class AuditoriumRepository implements IBaseRepository<Auditorium> {

    @Resource(name = "auditorium")
    private Map<Integer, Auditorium> auditoriumMap;


    @Override
    public void insert(Auditorium auditorium) {
        auditoriumMap.put(auditorium.getId(), auditorium);
    }

    @Override
    public Auditorium read(int id) {
        return auditoriumMap.get(id);
    }

    @Override
    public void delete(Auditorium auditorium) {
        auditoriumMap.remove(auditorium.getId());
    }

    @Override
    public void update(Auditorium auditorium) {
        auditoriumMap.put(auditorium.getId(), auditorium);
    }

    @Override
    public Collection<Auditorium> readAll() {
        return auditoriumMap.values();
    }

    public void setAuditoriumMap(Map<Integer, Auditorium> auditoriumMap) {
        this.auditoriumMap = auditoriumMap;
    }

}
