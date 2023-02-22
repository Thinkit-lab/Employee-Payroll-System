package com.devlon.payroll.services;

import com.devlon.payroll.dto.PayrollDTO;
import com.devlon.payroll.entity.Payroll;
import com.devlon.payroll.exception.EmployeeNotFoundException;

public interface PayrollService {
    PayrollDTO addPayroll(PayrollDTO payrollDTO, Long empId) throws EmployeeNotFoundException;

    Payroll getPayrollByEmpId(Long empId) throws EmployeeNotFoundException;

}
