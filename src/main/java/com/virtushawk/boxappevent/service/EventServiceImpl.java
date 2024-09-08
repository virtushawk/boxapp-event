package com.virtushawk.boxappevent.service;

import com.virtushawk.boxappevent.model.Event;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link EventService}
 */
@Service
public class EventServiceImpl implements EventService {

    private final CrudRepository<Event, String> eventRepository;

    public EventServiceImpl(CrudRepository<Event, String> eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event getById(String eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    @Override
    public List<Event> findAll() {
        return (List<Event>) eventRepository.findAll();
    }

    @Override
    public Event create(Event event) {
        return eventRepository.save(event);
    }


}
