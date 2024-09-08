package com.virtushawk.boxappevent.controller;

import com.virtushawk.boxappevent.conf.SimpleConfiguration;
import com.virtushawk.boxappevent.model.Event;
import com.virtushawk.boxappevent.model.dto.controller.EventCreateDTO;
import com.virtushawk.boxappevent.model.dto.controller.EventDTO;
import com.virtushawk.boxappevent.model.dto.controller.MembersInformationDTO;
import com.virtushawk.boxappevent.model.dto.controller.UserRegistrationCreateDTO;
import com.virtushawk.boxappevent.service.EventService;
import com.virtushawk.boxappevent.service.RegistrationService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main controller for this service
 */
@RestController
@RequestMapping("/v1/events")
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    private final EventService eventService;
    private final RegistrationService registrationService;
    private final SimpleConfiguration simpleConfiguration;
    private final RedisTemplate<String, Object> redisTemplate;

    public EventController(EventService eventService, RegistrationService registrationService, SimpleConfiguration simpleConfiguration, RedisTemplate<String, Object> redisTemplate) {
        this.eventService = eventService;
        this.registrationService = registrationService;
        this.simpleConfiguration = simpleConfiguration;
        this.redisTemplate = redisTemplate;
    }

    
    @GetMapping("{eventId}")
    public EventDTO get(@PathVariable("eventId") String eventId) {
        return mapToDTO(eventService.getById(eventId));
    }

    @GetMapping
    public List<EventDTO> getAll() {
        logger.info("Get all requested");
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
    public MembersInformationDTO getMembers(@PathVariable String eventId) {
        logger.info("Get members requested");
        MembersInformationDTO membersInformationDTO = new MembersInformationDTO();
        membersInformationDTO.setUserRegistrationDTOList(registrationService.findMembers(eventId));
        membersInformationDTO.setRedisFlag((double) redisTemplate.opsForValue().get("redisFlag"));
        return membersInformationDTO;
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
