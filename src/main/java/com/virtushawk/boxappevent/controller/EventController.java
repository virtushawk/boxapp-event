package com.virtushawk.boxappevent.controller;

import com.virtushawk.boxappevent.model.Event;
import com.virtushawk.boxappevent.model.dto.controller.EventDTO;
import com.virtushawk.boxappevent.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/events")
public class EventController {

    EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("{eventId}")
    public EventDTO getEvent(@PathVariable("eventId") String eventId) {
        return mapToDTO(eventService.getById(eventId));
    }

    private EventDTO mapToDTO(Event event) {
        if (event == null) {
            EventDTO nullableEvent = new EventDTO();
            nullableEvent.setId("null");
            return nullableEvent;
        }
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        return dto;
    }
}
