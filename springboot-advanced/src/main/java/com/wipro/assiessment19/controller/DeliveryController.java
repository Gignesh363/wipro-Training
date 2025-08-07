package com.wipro.assiessment19.controller;

import com.wipro.assiessment19.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/check-delivery")
    public String checkDeliveryStatus() {
        return deliveryService.getDeliveryStatus();
    }
}
