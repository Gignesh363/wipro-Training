package com.example.autowire;

import org.springframework.stereotype.Component;

@Component("roomA")
public class DormRoom {
    private int number = 101;
    private String building = "A Block";

    public String getLocation() {
        return "Room " + number + " in " + building;
    }
}
