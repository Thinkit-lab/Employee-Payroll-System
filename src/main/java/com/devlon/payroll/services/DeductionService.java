package com.devlon.payroll.services;

import com.devlon.payroll.dto.DeductionDTO;
import com.devlon.payroll.entity.Deduction;
import com.devlon.payroll.exception.EmployeeNotFoundException;

public interface DeductionService {
    DeductionDTO saveDeduction(DeductionDTO deductionDTO, Long empId) throws EmployeeNotFoundException;
}
