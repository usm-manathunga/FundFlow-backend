package org.example.fundflow.repository;

import org.example.fundflow.entity.Customer;
import org.example.fundflow.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication,Long> {
    List<LoanApplication> findByCustomer(Customer customer);
    List<LoanApplication> findAll();
}
