package com.devlon.payroll.services;

import com.devlon.payroll.dto.BankDetailsDTO;
import com.devlon.payroll.entity.BankDetails;
import com.devlon.payroll.exception.AlreadyExistException;
import com.devlon.payroll.exception.EmployeeNotFoundException;

public interface BankDetailsService {
    BankDetailsDTO saveBankDetails(BankDetailsDTO bankDetailsDTO, Long empId) throws EmployeeNotFoundException, AlreadyExistException;
}
