package com.alt.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alt.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {



    @GetMapping("/process")
    public void process(@RequestParam("msg") String msg) {
        //service.process(msg);
    }
}
