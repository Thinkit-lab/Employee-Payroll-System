package com.devlon.payroll.services.implementations;

import com.devlon.payroll.dto.AccountDetailsDTO;
import com.devlon.payroll.entity.AccountDetails;
import com.devlon.payroll.entity.BankDetails;
import com.devlon.payroll.entity.Employee;
import com.devlon.payroll.exception.AlreadyExistException;
import com.devlon.payroll.exception.EmployeeNotFoundException;
import com.devlon.payroll.repository.AccountDetailsRepo;
import com.devlon.payroll.services.AccountDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {
    private final AccountDetailsRepo accountDetailsRepo;
    private final EmployeeServiceImpl employeeService;

    public AccountDetailsServiceImpl(AccountDetailsRepo accountDetailsRepo, EmployeeServiceImpl employeeService) {
        this.accountDetailsRepo = accountDetailsRepo;
        this.employeeService = employeeService;
    }

    @Override
    public AccountDetailsDTO saveAccount(Long empId, AccountDetailsDTO accountDetailsDTO)
            throws EmployeeNotFoundException, AlreadyExistException {
        Employee employee = employeeService.getEmployeeById(empId);
        AccountDetails accountDetails = new AccountDetails();
        BeanUtils.copyProperties(accountDetailsDTO, accountDetails);

        AccountDetails existingAccountDetails = accountDetailsRepo.findByAccountNumber(accountDetailsDTO.getAccountNumber());

        if(existingAccountDetails != null) {
            throw new AlreadyExistException("Employee already exist");
        }
        accountDetails.setEmployee(employee);
        return mapToAccountDetails(accountDetailsRepo.save(accountDetails));
    }

    public AccountDetailsDTO mapToAccountDetails(AccountDetails accountDetails) {
        return AccountDetailsDTO.builder()
                .accountNumber(accountDetails.getAccountNumber())
                .accountType(accountDetails.getAccountType())
                .build();
    }
}
