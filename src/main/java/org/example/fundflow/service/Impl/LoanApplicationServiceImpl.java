package org.example.fundflow.service.Impl;

import org.example.fundflow.dto.LoanApplicationDTO;
import org.example.fundflow.entity.Customer;
import org.example.fundflow.entity.LoanApplication;
import org.example.fundflow.entity.LoanLog;
import org.example.fundflow.repository.CustomerRepository;
import org.example.fundflow.repository.LoanApplicationRepository;
import org.example.fundflow.repository.LoanLogRepository;
import org.example.fundflow.service.CustomerService;
import org.example.fundflow.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {
    private final LoanApplicationRepository repository;
    private final CustomerService customerService;

    @Autowired
    private LoanLogRepository loanLogRepository;


    public LoanApplicationServiceImpl(LoanApplicationRepository repository, CustomerService customerService) {
        this.repository = repository;

        this.customerService = customerService;
    }


    @Override
    public LoanApplication applyLoan(LoanApplicationDTO dto) {
        System.out.println(" Loan Dto : "+dto);
//        Customer customer = customerService.getCustomerByNic(NIC);
        Customer customer = customerService.getCustomerById(dto.getId());
        LoanApplication loan = new LoanApplication();
        loan.setLoanAmount(dto.getLoanAmount());
        loan.setDurationMonths(dto.getDurationMonths());
        loan.setPurpose(dto.getPurpose());
        loan.setMonthlyIncome(dto.getMonthlyIncome());
        loan.setExistingLoans(dto.getExistingLoans());
        loan.setCustomer(customer);


        double emi = dto.getLoanAmount() / dto.getDurationMonths();
        int score = 0;
        if (emi <= dto.getMonthlyIncome() * 0.4) score += 30;
        if (dto.getExistingLoans() <= 2) score += 20;
        if (dto.getLoanAmount() < 500000) score += 20;
        if (customer.getCreditScore() >= 700) score += 30;

        loan.setScore(score);
        if (score >= 70) {
            loan.setStatus("Approved");
            loan.setRecommendation("Eligible for " + dto.getDurationMonths() + "-month loan at 14% interest");
        } else {
            loan.setStatus("Rejected");
            loan.setRecommendation("Not eligible based on current profile");
        }

        LoanLog log = new LoanLog();
        log.setNic(customer.getNic());
        log.setLoanAmount(dto.getLoanAmount());
        log.setDurationMonths(dto.getDurationMonths());
        log.setPurpose(dto.getPurpose());
        log.setScore(score);
        log.setStatus(loan.getStatus());
        log.setRecommendation(loan.getRecommendation());
        log.setTimestamp(LocalDateTime.now());

        loanLogRepository.save(log);
        return repository.save(loan);
    }

    @Override
    public List<LoanApplication> getLoanApplicationsByUser(Customer customer) {
        return repository.findByCustomer(customer);
    }

    public List<LoanApplication> getAllLoans() {
        return repository.findAll(); // returns all loans with customer relationship
    }


}
