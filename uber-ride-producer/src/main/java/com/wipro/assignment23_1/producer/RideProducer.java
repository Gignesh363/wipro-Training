package com.wipro.assignment23_1.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RideProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public RideProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Object message) {
        kafkaTemplate.send(topic, message);
        System.out.println("✅ Sent message to topic '" + topic + "': " + message);
    }

    // Convenience method for the default ride topic
    public void sendRide(Object message) {
        sendMessage("ride_topic", message);
    }
}
