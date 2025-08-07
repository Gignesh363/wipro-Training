package com.wipro.assiessment19.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryService {

    private static final String DELIVERY_SERVICE = "deliveryService";

    @CircuitBreaker(name = DELIVERY_SERVICE, fallbackMethod = "fallbackDeliveryStatus")
    public String getDeliveryStatus() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9096/delivery/status";

        // Add Basic Auth credentials
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin", "admin");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    // Fallback method
    public String fallbackDeliveryStatus(Throwable throwable) {
        System.err.println("Fallback triggered due to: " + throwable.getMessage());
        return "Delivery Service is currently unavailable. Please try again later.";
    }
}
