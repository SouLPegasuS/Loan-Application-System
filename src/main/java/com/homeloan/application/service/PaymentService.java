package com.homeloan.application.service;

import com.homeloan.application.model.Payment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaymentService {

    public ResponseEntity<Payment> getPaymentById(long paymentId);

    public ResponseEntity<List<Payment>> getPaymentsByUser(long userId);

    public ResponseEntity<Payment> makePayment(Payment payment);

}
