package com.example.uber_ride_consumer.controller;

import com.example.uber_ride_consumer.model.Ride;
import com.example.uber_ride_consumer.service.RideService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideQueryController {

    private final RideService rideService;

    public RideQueryController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return rideService.getAllRides();
    }
}
