package com.homeloan.application.controller;

import com.homeloan.application.model.Loan;
import com.homeloan.application.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/payment")
public class PaymentController {
    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(){

    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Payment>> getPaymentsByUser(){

    }

    @PostMapping("/pay")
    public ResponseEntity<Payment> makePayment(){

    }


}
