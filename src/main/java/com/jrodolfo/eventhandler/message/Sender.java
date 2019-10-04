package com.jrodolfo.eventhandler.message;

import com.jrodolfo.eventhandler.model.Topic;
import com.jrodolfo.eventhandler.model.dto.EventDTO;
import com.jrodolfo.eventhandler.service.EventService;
import com.jrodolfo.eventhandler.service.EventServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@Component
@EnableJms
@Slf4j
public class Sender implements ApplicationContextAware {

    private static ApplicationContext context;

    private static final EventService eventService = new EventServiceImpl();

    @Override
    public void setApplicationContext(@NonNull ApplicationContext context) throws BeansException {
        log.info("Running Sender.setApplicationContext()...");
        Sender.context = context;
    }

    public void sendMessages() {
        log.info("Running Sender.sendMessage()...");
        if (context != null) {
            JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
            for (int i=1; i<=10; i++) {
                // Sending a message with a pojo
                log.info("Sending nt_inu_partyrole_event_dev message {}...", i);
                EventDTO eventDTO = eventService.getEvent(i);
                String destination = Topic.TOPIC_01.toString();
                jmsTemplate.convertAndSend(destination, eventDTO);
            }
        } else {
            log.info("sendMessage() - applicationContext is null");
        }
    }

    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        log.info("Running Sender.JmsListenerContainerFactory()...");
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // The code below provides the Spring Boot's default to this factory, including message converter,
        // but if necessary, we can override some of the Spring Boot's default
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        log.info("Running Sender.MessageConverter()...");
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
