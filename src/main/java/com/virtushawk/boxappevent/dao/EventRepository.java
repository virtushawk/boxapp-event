package com.virtushawk.boxappevent.dao;

import com.virtushawk.boxappevent.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {

}
