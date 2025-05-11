package org.example.fundflow.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoanApplicationDTO {
    private Double loanAmount;
    private Integer durationMonths;
    private String purpose;
    private Double monthlyIncome;
    private Integer existingLoans;
    private Long id;
}
