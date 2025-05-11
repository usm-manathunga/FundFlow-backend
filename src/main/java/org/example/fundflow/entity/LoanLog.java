package org.example.fundflow.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "loan_logs")
@Getter
@Setter
public class LoanLog {
    @Id
    private String id;
    private String nic;
    private Double loanAmount;
    private Integer durationMonths;
    private String purpose;
    private Integer score;
    private String status;
    private String recommendation;
    private LocalDateTime timestamp;
}
