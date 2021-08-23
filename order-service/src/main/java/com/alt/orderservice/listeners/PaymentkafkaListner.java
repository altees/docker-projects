package com.alt.orderservice.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentkafkaListner {


    @KafkaListener(topics = "alteesTopic", groupId = "alteesGroup")
    public void listenTopic(String msg) {
        System.out.println("Listing from order-service ==> " + msg);
    }
}
