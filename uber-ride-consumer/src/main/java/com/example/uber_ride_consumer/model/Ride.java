package com.example.uber_ride_consumer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;   // Correct import for Transient

@Entity
@Table(name = "rides")
public class Ride {

    @Id
    private Long id;

    private String passengerName;
    private String pickupLocation;
    private String dropLocation;

    // operation is not stored in DB; used only for Kafka message handling
    @Transient
    private String operation;

    public Ride() {}

    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }
    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }
    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
}
