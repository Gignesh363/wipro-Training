package com.example.uber_ride_producer.service;

import com.example.uber_ride_producer.model.Ride;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kafka.topic.name}")
    private String topicName;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendRideMessage(Ride ride) throws JsonProcessingException {
        String rideJson = objectMapper.writeValueAsString(ride);
        kafkaTemplate.send(topicName, rideJson);
        System.out.println("✅ Sent to Kafka: " + rideJson);
    }
}
