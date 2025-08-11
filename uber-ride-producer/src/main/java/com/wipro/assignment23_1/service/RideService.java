package com.wipro.assignment23_1.service;

import com.wipro.assignment23_1.model.Ride;
import com.wipro.assignment23_1.producer.RideProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class RideService {

    private final RestTemplate restTemplate;
    private final RideProducer rideProducer;

    public RideService(RestTemplate restTemplate, RideProducer rideProducer) {
        this.restTemplate = restTemplate;
        this.rideProducer = rideProducer;
    }

    public String bookRide(String pickup, String drop, double fare) {
        // Step 1: Book the ride locally
        Ride ride = new Ride(1L, "John Driver", "Alice Passenger", pickup, drop, fare);
        String rideDetails = "Ride booked from " + pickup + " to " + drop + " with fare: ₹" + fare;

        // Step 2: Send ride details to Kafka
        rideProducer.sendRide(ride);

        // Step 3: Call Payment Service for payment
        String paymentServiceUrl = "http://localhost:8082/payment";

        Map<String, Object> paymentRequest = new HashMap<>();
        paymentRequest.put("amount", fare);
        paymentRequest.put("mode", "UPI");
        paymentRequest.put("status", "PENDING");

        ResponseEntity<String> paymentResponse =
                restTemplate.postForEntity(paymentServiceUrl, paymentRequest, String.class);

        // Step 4: Combine responses
        return rideDetails + " | Payment Service Response: " + paymentResponse.getBody();
    }
}
