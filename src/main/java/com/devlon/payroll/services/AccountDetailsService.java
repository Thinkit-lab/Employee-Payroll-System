package com.devlon.payroll.services;

import com.devlon.payroll.dto.AccountDetailsDTO;
import com.devlon.payroll.entity.AccountDetails;
import com.devlon.payroll.entity.Employee;
import com.devlon.payroll.exception.AlreadyExistException;
import com.devlon.payroll.exception.EmployeeNotFoundException;

public interface AccountDetailsService {
    AccountDetailsDTO saveAccount(Long empId, AccountDetailsDTO accountDetailsDTO) throws EmployeeNotFoundException, AlreadyExistException;
}
