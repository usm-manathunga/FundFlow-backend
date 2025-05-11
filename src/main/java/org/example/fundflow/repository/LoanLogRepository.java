package org.example.fundflow.repository;

import org.example.fundflow.entity.LoanLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanLogRepository extends MongoRepository<LoanLog, String> {
}
