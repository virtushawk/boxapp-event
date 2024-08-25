package com.virtushawk.boxappevent.service;

import com.virtushawk.boxappevent.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final CrudRepository<Event, String> eventRepository;

    public EventService(CrudRepository<Event, String> eventRepository) {
        this.eventRepository = eventRepository;
    }



}
