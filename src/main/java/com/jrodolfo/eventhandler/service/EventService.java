package com.jrodolfo.eventhandler.service;

import com.jrodolfo.eventhandler.model.dto.EventDTO;

public interface EventService {
    EventDTO getEvent(Integer eventId);
}
