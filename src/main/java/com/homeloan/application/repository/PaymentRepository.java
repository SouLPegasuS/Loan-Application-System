package com.homeloan.application.repository;

import com.homeloan.application.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByPaymentId(long paymentId);

    List<Payment> findAllByUserId(long userId);
}
