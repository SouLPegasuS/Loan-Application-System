package com.homeloan.application.controller;

import com.homeloan.application.model.Loan;
import com.homeloan.application.model.LoanRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/loanRequest")
public class LoanRequestController {
    @GetMapping("/")
    public ResponseEntity<List<LoanRequest>> getLoanRequests(){

    }

    @GetMapping("/{loanRequestId}")
    public ResponseEntity<LoanRequest> getLoanRequestById(){

    }

    @GetMapping("/{userId}")
    public ResponseEntity<Loan> getLoanRequestsByUser(){

    }

    @PostMapping("/approve")
    public ResponseEntity<Loan> approveLoanRequest(){

    }

    @PostMapping("/decline")
    public ResponseEntity<Loan> declineLoanRequest(){

    }

    @PutMapping("/edit")
    public ResponseEntity<Loan> editLoanRequest(){

    }
}
