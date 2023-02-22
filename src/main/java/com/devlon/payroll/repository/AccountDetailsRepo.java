package com.devlon.payroll.repository;

import com.devlon.payroll.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDetailsRepo extends JpaRepository<AccountDetails, Long> {
    AccountDetails findByAccountNumber(String accountNumber);
}
