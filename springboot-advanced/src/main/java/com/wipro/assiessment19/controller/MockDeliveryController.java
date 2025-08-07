package com.wipro.assiessment19.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockDeliveryController {

    @GetMapping("/delivery/status")
    public String getStatus() {
        return "Your delivery is on the way!";
    }
}
