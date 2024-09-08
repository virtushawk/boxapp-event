package com.virtushawk.boxappevent.service;

import com.virtushawk.boxappevent.model.Event;
import java.util.List;

/**
 * Service for the {@link Event}
 */
public interface EventService {

    /**
     * Get {@link Event} by id
     *
     * @param eventId event id
     * @return {@link Event} entity
     */
    Event getById(String eventId);

    /**
     * Find all {@link Event} entities
     *
     * @return list of {@link Event} entities or empty list if nothing is found
     */
    List<Event> findAll();

    /**
     * Create {@link Event} entity
     *
     * @param event to create
     * @return created event
     */
    Event create(Event event);
}
