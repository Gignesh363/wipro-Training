package com.example.uber_ride_producer.model;

public class Ride {
    private Long id;
    private String passengerName;
    private String pickupLocation;
    private String dropLocation;
    private String operation; // CREATE, UPDATE, DELETE

    public Ride() {}

    public Ride(Long id, String passengerName, String pickupLocation, String dropLocation, String operation) {
        this.id = id;
        this.passengerName = passengerName;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.operation = operation;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public String getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }

    public String getDropLocation() { return dropLocation; }
    public void setDropLocation(String dropLocation) { this.dropLocation = dropLocation; }

    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }
}
