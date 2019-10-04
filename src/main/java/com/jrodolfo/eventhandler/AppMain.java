package com.jrodolfo.eventhandler;

import com.jrodolfo.eventhandler.message.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AppMain {

    public static void main(String[] args) {
        // Launching the application
        log.info("Running AppMain.main()...");
        SpringApplication.run(AppMain.class, args);
        // Send messages
        (new Sender()).sendMessages();
    }
}
