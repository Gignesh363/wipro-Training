package com.wipro.assignment23_1.controller;

import com.wipro.assignment23_1.producer.RideProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final RideProducer rideProducer;

    public RideController(RideProducer rideProducer) {
        this.rideProducer = rideProducer;
    }

    @PostMapping("/send")
    public String sendRide(@RequestBody Object ride) {
        rideProducer.sendRide(ride);
        return "✅ Ride sent to Kafka successfully!";
    }
}
