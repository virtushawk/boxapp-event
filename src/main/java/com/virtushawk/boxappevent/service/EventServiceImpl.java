package com.virtushawk.boxappevent.service;

import com.virtushawk.boxappevent.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

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
}
