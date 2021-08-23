package com.alt.orderservice.util;

import com.alt.orderservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class PaymentUtil {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private String kafkaTopic = "alteesTopic";

    public PaymentService paymentServices = msg -> {
        kafkaTemplate.send(kafkaTopic, msg);
    };
}
