package com.jrodolfo.eventhandler.model.entity;

import javax.persistence.*;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class EventEntity {

    @Id
    // TODO: not sure about the policy that defines the event_id:
    // this id can be created and sent in the message, so we do
    // not need to trigger the auto generation of id
    //  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="event_id")
    private Integer eventId;

    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    @Column(name = "topic", nullable = false)
    private String topic;
}
