package com.jrodolfo.eventhandler.model.repository;

import com.jrodolfo.eventhandler.model.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<EventEntity, Long> {
}
