package com.example.demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    // ✅ Logger added
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    @PostMapping("/webhook")
    public Map<String, String> handleMessage(@RequestBody Map<String, String> body) {

        String message = body.get("message");

        // ✅ Logging incoming message (MANDATORY requirement)
        logger.info("Received message: {}", message);

        String reply;

        if ("Hi".equalsIgnoreCase(message)) {
            reply = "Hello";
        } else if ("Bye".equalsIgnoreCase(message)) {
            reply = "Goodbye";
        } else {
            reply = "I didn't understand that.";
        }

        return Map.of("reply", reply);
    }
}