package com.jrodolfo.eventhandler.message;

import com.jrodolfo.eventhandler.model.Topic;
import com.jrodolfo.eventhandler.model.dto.EventDTO;
import com.jrodolfo.eventhandler.model.entity.EventEntity;
import com.jrodolfo.eventhandler.model.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Receiver {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private EventRepository eventRepository;

    @JmsListener(destination = Topic.Constants.TOPIC_01_VALUE, containerFactory = "myFactory")
    public void receiveMessage(EventDTO eventDTO) {
        log.info("Running Receiver.receiveMessage()...");
        log.info("Message was received: " + eventDTO);
        logMessage(eventDTO);
        showLog();
    }

    private void logMessage(EventDTO eventDTO) {
        log.info("Running Receiver.logMessage()...");
        EventEntity eventEntity = EventEntity
                .builder()
                .eventId(eventDTO.getEventId())
                .dateCreated(new java.sql.Date(eventDTO.getDateCreated().getTime()))
                .userId(eventDTO.getUserId())
                .eventType(eventDTO.getEventType())
                .topic(eventDTO.getTopic().toString())
                .build();
        eventRepository.save(eventEntity);
    }

    private void showLog() {
        for (EventEntity eventEntity : eventRepository.findAll()) {
            log.info("The event logged is: " + eventEntity.toString());
        }
    }
}
