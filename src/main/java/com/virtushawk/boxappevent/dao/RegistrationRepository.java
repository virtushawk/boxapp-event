package com.virtushawk.boxappevent.dao;

import com.virtushawk.boxappevent.model.Event;
import com.virtushawk.boxappevent.model.Registration;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Registration} entity
 */
@Repository
public interface RegistrationRepository extends CrudRepository<Registration, String> {

    /**
     * Find all usernames registered to the event
     *
     * @param event event object
     * @return list of usernames that registered to the event
     */
    @Query("SELECT r.userName FROM Registration r WHERE r.event =:event")
    List<String> findAllUsersByEvent(Event event);

    /**
     * Delete All registration for user
     *
     * @param userName username
     */
    void deleteAllByUserName(String userName);
}
