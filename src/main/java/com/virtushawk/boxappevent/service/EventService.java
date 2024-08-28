package com.virtushawk.boxappevent.service;

import com.virtushawk.boxappevent.model.Event;
import com.virtushawk.boxappevent.model.dto.controller.UserRegistrationCreateDTO;
import java.util.List;

public interface EventService {

    Event getById(String eventId);

    List<Event> findAll();

    Event create(Event event);
}
