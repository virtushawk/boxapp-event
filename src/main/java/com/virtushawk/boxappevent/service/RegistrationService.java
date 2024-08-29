package com.virtushawk.boxappevent.service;

import com.virtushawk.boxappevent.model.dto.controller.UserRegistrationCreateDTO;
import com.virtushawk.boxappevent.model.dto.controller.UserRegistrationDTO;
import java.util.List;

public interface RegistrationService {

    void registerUser(String eventId, UserRegistrationCreateDTO userRegistrationCreateDTO);

    List<UserRegistrationDTO> findMembers(String eventId);

    void deleteAllAssignedToUsername(String username);
}