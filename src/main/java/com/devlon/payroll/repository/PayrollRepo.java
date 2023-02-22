package com.devlon.payroll.repository;

import com.devlon.payroll.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PayrollRepo extends JpaRepository<Payroll, Long> {
    @Query(value = "SELECT * from payroll p where p.emp_id = ?1",
    nativeQuery = true)
    Payroll findByEmpId(Long empId);
}
