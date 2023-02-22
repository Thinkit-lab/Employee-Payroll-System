package com.devlon.payroll.repository;

import com.devlon.payroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);

    Employee findByEmail(String email);
}
