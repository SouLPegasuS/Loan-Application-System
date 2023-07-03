package com.homeloan.application.service;

import com.homeloan.application.model.Loan;
import com.homeloan.application.model.LoanRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoanRequestService {
    public ResponseEntity<List<LoanRequest>> getAllLoanRequests();

    public ResponseEntity<LoanRequest> getLoanRequestById(long loanRequestId);

    public ResponseEntity<List<LoanRequest>> getLoanRequestsByUser(long userId);

    public ResponseEntity<LoanRequest> addLoanRequest(LoanRequest loanRequest);

    public void deleteLoanRequest(long loanRequestId);

    public ResponseEntity<LoanRequest> approveLoan(LoanRequest loanRequest, long loanRequestId);

    public ResponseEntity<LoanRequest> declineLoan(long loanRequestId);

    public ResponseEntity<LoanRequest> editLoanRequest(LoanRequest loanRequest, long loanRequestId);
}
