package com.jrodolfo.eventhandler.model.dto;

import com.jrodolfo.eventhandler.model.Topic;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDTO {
    private Integer eventId;
    private Date dateCreated;
    private Integer userId;
    private String eventType;
    private Topic topic;
}
