package com.virtushawk.boxappevent.dao;

import com.virtushawk.boxappevent.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Event} entity
 */
@Repository
public interface EventRepository extends CrudRepository<Event, String> {

}
