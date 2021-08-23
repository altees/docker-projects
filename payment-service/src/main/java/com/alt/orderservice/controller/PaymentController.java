package com.alt.orderservice.controller;

import com.alt.orderservice.util.PaymentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentUtil paymentUtil;


    @GetMapping("/process")
    public void process(@RequestParam("msg") String msg) {
        paymentUtil.paymentServices.process(msg);
    }
}
