package com.alt.paymentservice.util;

import com.alt.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;


public class PaymentUtil {

    @Autowired
    private KafkaTemplate<String,String> template;
    private String kafkaTopic="alteesTopic";


    //pushing message to kafka topics
    static PaymentService service = msg -> {
            // to do...
    };
}
