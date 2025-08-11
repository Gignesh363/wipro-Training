package com.wipro.assignment23_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RideConsumerController {

    @GetMapping("/consumer/status")
    public String getStatus() {
        return "✅ Ride Consumer Service is running and listening to Kafka topic.";
    }
}
