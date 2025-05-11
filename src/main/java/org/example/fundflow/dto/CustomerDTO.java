package org.example.fundflow.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerDTO {
    private String name;
    private String nic;
    private String email;
    private Double monthlyIncome;
}
