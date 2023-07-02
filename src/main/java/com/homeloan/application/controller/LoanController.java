package com.homeloan.application.controller;

import com.homeloan.application.model.Loan;
import com.homeloan.application.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/loan")
public class LoanController {

    @GetMapping("/")
    public ResponseEntity<List<Loan>> getLoans(){

    }

    @GetMapping("/{loanId}")
    public ResponseEntity<Loan> getLoanById(){

    }

    @GetMapping("/{userId}")
    public ResponseEntity<Loan> getLoansByUser(){

    }



}
