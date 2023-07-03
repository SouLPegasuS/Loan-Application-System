package com.homeloan.application.service;

import com.homeloan.application.model.Loan;
import com.homeloan.application.model.LoanRequest;
import com.homeloan.application.model.User;
import com.homeloan.application.repository.LoanRepository;
import com.homeloan.application.repository.LoanRequestRepository;
import com.homeloan.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Math.pow;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    @Autowired
    LoanRequestRepository loanRequestRepo;
    @Autowired
    UserRepository userRepo;

    @Autowired
    LoanRepository loanRepo;

    public ResponseEntity<List<LoanRequest>> getAllLoanRequests(){
        List<LoanRequest> loanRequestList = loanRequestRepo.findAll();
        return new ResponseEntity<>(loanRequestList, HttpStatus.OK);
    }

    public ResponseEntity<LoanRequest> getLoanRequestById(long loanRequestId){
        LoanRequest loanRequest = loanRequestRepo.findByLoanRequestId(loanRequestId);
        return new ResponseEntity<>(loanRequest, HttpStatus.OK);
    }

    public ResponseEntity<List<LoanRequest>> getLoanRequestsByUser(long userId){
        List<LoanRequest> loanRequestList = loanRequestRepo.findAllByUserId(userId);
        return new ResponseEntity<>(loanRequestList, HttpStatus.OK);
    }

    public ResponseEntity<LoanRequest> addLoanRequest(LoanRequest loanRequest){
        loanRequestRepo.save(loanRequest);
        return new ResponseEntity<>(loanRequest, HttpStatus.CREATED);
    }

    public void deleteLoanRequest(long loanRequestId){
        loanRequestRepo.deleteById(loanRequestId);
        return;
    }

    public ResponseEntity<LoanRequest> editLoanRequest(LoanRequest loanRequest, long loanRequestId){
        loanRequestRepo.save(loanRequest);
        return new ResponseEntity<>(loanRequest, HttpStatus.OK);
    }

    double calculateEMI(long amount, double interestRate, double tenure){
        double emi = (amount*interestRate*(pow((1+interestRate),tenure)))/(pow((1+interestRate),tenure)-1);
        return emi;
    }

    public ResponseEntity<LoanRequest> approveLoan(LoanRequest loanRequest, long loanRequestId){
        User user = userRepo.findByUserId(loanRequest.getUserId());
        if(loanRequest.getAmount() > 50*user.getSalary()){
            declineLoan(loanRequestId);
            return new ResponseEntity<>(loanRequest, HttpStatus.OK);
        }
        else{
            Loan loan = new Loan();
            loan.setUserId(user.getUserId());
            loan.setOutstandingBalance(loanRequest.getAmount());
            loan.setTenure(loanRequest.getTenure());
            double emi = calculateEMI(loanRequest.getAmount(), 0.07/12.0, loanRequest.getTenure()*12);
            loan.setEmi(emi);
            loan.setInterestRate(0.07);

            loanRepo.save(loan);
            loanRequest.setStatus("approved");
            loanRequestRepo.save(loanRequest);
            return new ResponseEntity<>(loanRequest, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<LoanRequest> declineLoan(long loanRequestId){
        LoanRequest loanRequest = loanRequestRepo.findByLoanRequestId(loanRequestId);
        loanRequest.setStatus("declined");
        loanRequestRepo.save(loanRequest);
        return new ResponseEntity<>(loanRequest, HttpStatus.OK);
    }

}
