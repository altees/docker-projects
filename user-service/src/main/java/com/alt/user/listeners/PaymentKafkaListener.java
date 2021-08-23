package com.alt.user.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentKafkaListener {


    @KafkaListener(topics = "alteesTopic", groupId = "alteesGroup")
    public void listenTopic(String msg) {
        System.out.println("Listing from user-service ==> " + msg);
    }

}
