package com.devlon.payroll.repository;

import com.devlon.payroll.entity.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepo extends JpaRepository<BankDetails, Long> {
    BankDetails findByAccountNumber(String accountNumber);
}
