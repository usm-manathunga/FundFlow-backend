package org.example.fundflow.service;

import org.example.fundflow.dto.LoanApplicationDTO;
import org.example.fundflow.entity.Customer;
import org.example.fundflow.entity.LoanApplication;

import java.util.List;

public interface LoanApplicationService {
    public LoanApplication applyLoan(LoanApplicationDTO dto);

    public List<LoanApplication> getLoanApplicationsByUser(Customer customer);

    public List<LoanApplication> getAllLoans();
}
