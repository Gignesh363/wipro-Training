package com.wipro.assignment23_1.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.wipro.assignment23_1.model.Ride;

@Service
public class RideConsumerService {

    @KafkaListener(
            topics = "uber_rides",
            groupId = "uber-ride-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeRide(Ride ride) {
        System.out.println("✅ Consumed Ride: " + ride);
    }
}
