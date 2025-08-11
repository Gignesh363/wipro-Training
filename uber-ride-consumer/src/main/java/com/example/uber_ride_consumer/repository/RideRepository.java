package com.example.uber_ride_consumer.repository;

import com.example.uber_ride_consumer.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {}
