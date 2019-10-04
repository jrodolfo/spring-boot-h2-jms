package com.jrodolfo.eventhandler.service;

import com.jrodolfo.eventhandler.model.Topic;
import com.jrodolfo.eventhandler.model.dto.EventDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    @Override
    public EventDTO getEvent(Integer eventId) {
        log.info("Running EventServiceImpl.getEvent()...");
        return EventDTO
                .builder()
                .eventId(eventId)
                .dateCreated(new Date())
                .userId(1)
                .eventType("some event type")
                .topic(Topic.TOPIC_01)
                .build();
    }
}
