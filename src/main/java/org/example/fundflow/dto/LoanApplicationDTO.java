package org.example.fundflow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoanApplicationDTO {
    private Double loanAmount;
    private Integer durationMonths;
    private String purpose;
    private Double monthlyIncome;
    private Integer existingLoans;
}
