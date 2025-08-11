package com.example.uber_ride_producer.controller;

import com.example.uber_ride_producer.model.Ride;
import com.example.uber_ride_producer.service.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final KafkaProducerService kafkaProducerService;

    public RideController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping
    public ResponseEntity<String> createRide(@RequestBody Ride ride) throws JsonProcessingException {
        ride.setOperation("CREATE");
        kafkaProducerService.sendRideMessage(ride);
        return ResponseEntity.ok("Ride message sent to Kafka");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRide(@PathVariable Long id, @RequestBody Ride ride) throws JsonProcessingException {
        ride.setId(id);
        ride.setOperation("UPDATE");
        kafkaProducerService.sendRideMessage(ride);
        return ResponseEntity.ok("Ride updated and message sent to Kafka");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRide(@PathVariable Long id) throws JsonProcessingException {
        Ride ride = new Ride();
        ride.setId(id);
        ride.setOperation("DELETE");
        kafkaProducerService.sendRideMessage(ride);
        return ResponseEntity.ok("Ride deletion message sent to Kafka");
    }
}

