package com.virtushawk.boxappevent.dao;

import com.virtushawk.boxappevent.model.Event;
import com.virtushawk.boxappevent.model.Registration;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration, String> {

    @Query("SELECT r.userName FROM Registration r WHERE r.event =:event")
    List<String> findAllUsersByEvent(Event event);

    void deleteAllByUserName(String userName);
}
