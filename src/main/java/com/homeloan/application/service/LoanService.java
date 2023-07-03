package com.homeloan.application.service;

import com.homeloan.application.model.Loan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoanService {
    public ResponseEntity<List<Loan>> getAllLoans();

    public ResponseEntity<Loan> getLoanById(long loanId);

    public ResponseEntity<List<Loan>> getLoansByUser(long userId);

}
