package com.virtushawk.boxappevent.service;

import com.virtushawk.boxappevent.dao.RegistrationRepository;
import com.virtushawk.boxappevent.model.Event;
import com.virtushawk.boxappevent.model.Registration;
import com.virtushawk.boxappevent.model.dto.controller.UserRegistrationCreateDTO;
import com.virtushawk.boxappevent.model.dto.controller.UserRegistrationDTO;
import com.virtushawk.boxappevent.model.service.BulkUserRequestDTO;
import com.virtushawk.boxappevent.service.feign.UserFeignClient;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private  final EventService eventService;
    private final RegistrationRepository registrationRepository;
    private final UserFeignClient userFeignClient;

    public RegistrationServiceImpl(EventService eventService, RegistrationRepository registrationRepository, UserFeignClient userFeignClient) {
        this.eventService = eventService;
        this.registrationRepository = registrationRepository;
        this.userFeignClient = userFeignClient;
    }

    @Override
    public void registerUser(String eventId, UserRegistrationCreateDTO userRegistrationCreateDTO) {
        Event event = eventService.getById(eventId);

        if (event == null) {
            throw new RuntimeException("Event with id " + eventId + " not found");
        }

        Registration registration = new Registration();
        registration.setEvent(event);
        registration.setUserName(userRegistrationCreateDTO.getUsername());

        registrationRepository.save(registration);
    }

    @Override
    public List<UserRegistrationDTO> findMembers(String eventId) {
        Event event = eventService.getById(eventId);

        if (event == null) {
            throw new RuntimeException("Event with id " + eventId + " not found");
        }

        List<String> usernames = registrationRepository.findAllUsersByEvent(event);

        BulkUserRequestDTO bulkUserRequestDTO = new BulkUserRequestDTO();
        bulkUserRequestDTO.setUsernames(usernames);

        return userFeignClient.fetchUsersData(bulkUserRequestDTO);
    }

    @Transactional
    @Override
    public void deleteAllAssignedToUsername(String username) {
        registrationRepository.deleteAllByUserName(username);
    }
}
