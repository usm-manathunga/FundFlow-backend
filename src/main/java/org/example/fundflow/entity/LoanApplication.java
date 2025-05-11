package org.example.fundflow.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double loanAmount;
    private Integer durationMonths;
    private String purpose;
    private Double monthlyIncome;
    private Integer existingLoans;

    private Integer score;
    private String status;
    private String recommendation;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
