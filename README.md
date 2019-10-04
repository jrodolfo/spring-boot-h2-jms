# Event Handler

Code created using what I learned from:

    Messaging with JMS
    https://spring.io/guides/gs/messaging-jms/
    
    Spring Boot Fundamentals - Kesha Williams, 1h 38m, Jul 2019
    https://app.pluralsight.com/library/courses/spring-boot-fundamentals/table-of-contents
    
    Spring Boot Microservices with Spring Cloud Beginner to Guru - John Thompson, 20h 21m, Aug 2019
    https://www.udemy.com/course/spring-boot-microservices-with-spring-cloud-beginner-to-guru

The code creates 10 messages, publish them into JMS Broker, and then consume the messages, 
save to an in-memory database (H2), and log into the console the messages being published
and consumed. I organized all the model code (entity, repository, and dto) into the model
folder. You will also find a service layer, and a message layer.

Check the database H2 on your browser at:

    http://localhost:8080/h2/

The datasource url is:

    jdbc:h2:~/test;DB_CLOSE_ON_EXIT=FALSE

Password is empty.

-Rod Oliveira
