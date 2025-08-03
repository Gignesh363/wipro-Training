package com.example.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Freshman {

    private String name = "MAHESH";

    @Autowired
    @Qualifier("roomA")
    private DormRoom room;

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room.getLocation();
    }
}
