package com.virtushawk.boxappevent.controller;

import com.virtushawk.boxappevent.conf.SimpleConfiguration;
import com.virtushawk.boxappevent.model.Event;
import com.virtushawk.boxappevent.model.dto.controller.EventCreateDTO;
import com.virtushawk.boxappevent.model.dto.controller.EventDTO;
import com.virtushawk.boxappevent.model.dto.controller.UserRegistrationCreateDTO;
import com.virtushawk.boxappevent.model.dto.controller.UserRegistrationDTO;
import com.virtushawk.boxappevent.service.EventService;
import com.virtushawk.boxappevent.service.RegistrationService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/events")
public class EventController {

    private final EventService eventService;
    private final RegistrationService registrationService;
    private final SimpleConfiguration simpleConfiguration;

    public EventController(EventService eventService, RegistrationService registrationService, SimpleConfiguration simpleConfiguration) {
        this.eventService = eventService;
        this.registrationService = registrationService;
        this.simpleConfiguration = simpleConfiguration;
    }

    @GetMapping("{eventId}")
    public EventDTO get(@PathVariable("eventId") String eventId) {
        return mapToDTO(eventService.getById(eventId));
    }

    @GetMapping
    public List<EventDTO> getAll() {
        return eventService.findAll().stream().map(this::mapToDTO).toList();
    }

    @PostMapping
    public EventDTO create(@RequestBody EventCreateDTO eventDTO) {
       return mapToDTO(eventService.create(mapToDTO(eventDTO)));
    }

    @PostMapping("{eventId}/register")
    public void registerUser(@PathVariable String eventId, @RequestBody UserRegistrationCreateDTO userRegistrationCreateDTO) {
        registrationService.registerUser(eventId, userRegistrationCreateDTO);
    }

    @GetMapping("{eventId}/members")
    public List<UserRegistrationDTO> getMembers(@PathVariable String eventId) {
        return registrationService.findMembers(eventId);
    }

    private EventDTO mapToDTO(Event event) {
        if (event == null) {
            EventDTO nullableEvent = new EventDTO();
            nullableEvent.setId("null");
            return nullableEvent;
        }
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setName(simpleConfiguration.getNameValue());
        return dto;
    }

    private Event mapToDTO(EventCreateDTO dto) {
        Event event = new Event();
        event.setName(dto.getName());
        return event;
    }
}
