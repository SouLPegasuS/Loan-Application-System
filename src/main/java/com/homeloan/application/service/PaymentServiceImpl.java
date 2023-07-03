package com.homeloan.application.service;

import com.homeloan.application.model.Loan;
import com.homeloan.application.model.Payment;
import com.homeloan.application.repository.LoanRepository;
import com.homeloan.application.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentRepository paymentRepo;

    @Autowired
    LoanRepository loanRepo;

    public ResponseEntity<Payment> getPaymentById(long paymentId){
        Payment payment = paymentRepo.findByPaymentId(paymentId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    public ResponseEntity<List<Payment>> getPaymentsByUser(long userId){
        List<Payment> paymentList = paymentRepo.findAllByUserId(userId);
        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }

    public ResponseEntity<Payment> makePayment(Payment payment){
        Loan loan = loanRepo.findByLoanId(payment.getLoanId());
        double principlePaid, interestPaid, newOutstandingBalance;
        interestPaid = loan.getOutstandingBalance()*loan.getInterestRate()/12;
        principlePaid = payment.getAmount()-interestPaid;
        newOutstandingBalance = loan.getOutstandingBalance()-principlePaid;
        loan.setOutstandingBalance(newOutstandingBalance);
        loanRepo.save(loan);
        paymentRepo.save(payment);
        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }


}
