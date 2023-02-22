package com.devlon.payroll.repository;

import com.devlon.payroll.entity.Deduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeductionRepo extends JpaRepository<Deduction, Long> {
}
