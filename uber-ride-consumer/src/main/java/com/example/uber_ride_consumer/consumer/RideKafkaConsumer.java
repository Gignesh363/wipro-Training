package com.example.uber_ride_consumer.consumer;

import com.example.uber_ride_consumer.model.Ride;
import com.example.uber_ride_consumer.service.RideService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RideKafkaConsumer {

    private final RideService rideService;
    private final ObjectMapper objectMapper;

    public RideKafkaConsumer(RideService rideService, ObjectMapper objectMapper) {
        this.rideService = rideService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> record) {
        String message = record.value();
        try {
            Ride ride = objectMapper.readValue(message, Ride.class);

            if ("CREATE".equalsIgnoreCase(ride.getOperation()) || "UPDATE".equalsIgnoreCase(ride.getOperation())) {
                rideService.saveOrUpdateRide(ride);
                System.out.println("Ride saved/updated: " + ride.getId());
            } else if ("DELETE".equalsIgnoreCase(ride.getOperation())) {
                rideService.deleteRide(ride.getId());
                System.out.println("Ride deleted: " + ride.getId());
            } else {
                System.out.println("Unknown operation: " + ride.getOperation());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
