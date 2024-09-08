package com.virtushawk.boxappevent.service;

import com.virtushawk.boxappevent.model.dto.controller.UserRegistrationCreateDTO;
import com.virtushawk.boxappevent.model.dto.controller.UserRegistrationDTO;
import java.util.List;

/**
 * Service for the {@link com.virtushawk.boxappevent.model.Registration} entity
 */
public interface RegistrationService {

    /**
     * Register user to the event
     *
     * @param eventId id of the {@link com.virtushawk.boxappevent.model.Event} entity
     * @param userRegistrationCreateDTO dto for user registration
     */
    void registerUser(String eventId, UserRegistrationCreateDTO userRegistrationCreateDTO);

    /**
     * Find all users that are registered to the {@link com.virtushawk.boxappevent.model.Event}
     *
     * @param eventId id of the event
     * @return list that contains all registered users
     */
    List<UserRegistrationDTO> findMembers(String eventId);

    /**
     * Delete All registrations of user
     *
     * @param username username
     */
    void deleteAllAssignedToUsername(String username);
}