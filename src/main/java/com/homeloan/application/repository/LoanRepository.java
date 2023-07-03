package com.homeloan.application.repository;

import com.homeloan.application.model.Loan;
import com.homeloan.application.model.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Loan findByLoanId(long loanId);
    List<Loan> findAllByUserId(long userId);

}
