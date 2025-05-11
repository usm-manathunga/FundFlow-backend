package org.example.fundflow.controller;

import org.example.fundflow.dto.LoanApplicationDTO;
import org.example.fundflow.entity.Customer;
import org.example.fundflow.entity.LoanApplication;
import org.example.fundflow.service.LoanApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/loan")
public class LoanApplicationController {
    private final LoanApplicationService service;

    public LoanApplicationController(LoanApplicationService service) {
        this.service = service;
    }

    @PostMapping("/apply")
    public ResponseEntity<LoanApplication> applyLoan(@RequestBody LoanApplicationDTO dto){
        return ResponseEntity.ok(service.applyLoan(dto));
    }

    @GetMapping("/my-applications")
    public ResponseEntity<List<LoanApplication>> getMyLoans(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.getLoanApplicationsByUser(customer));
    }

    @GetMapping("/getAllLoans")
    public ResponseEntity<List<LoanApplication>> getAllLoans() {
        return ResponseEntity.ok(service.getAllLoans());
    }
}
