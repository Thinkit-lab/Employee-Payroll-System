package com.devlon.payroll.services.implementations;


import com.devlon.payroll.dto.AccountDetailsDTO;
import com.devlon.payroll.dto.BankDetailsDTO;
import com.devlon.payroll.entity.AccountDetails;
import com.devlon.payroll.entity.BankDetails;
import com.devlon.payroll.entity.Employee;
import com.devlon.payroll.exception.AlreadyExistException;
import com.devlon.payroll.exception.EmployeeNotFoundException;
import com.devlon.payroll.repository.BankDetailsRepo;
import com.devlon.payroll.services.BankDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankDetailsServiceImpl implements BankDetailsService {
    private BankDetailsRepo bankDetailsRepo;
    private EmployeeServiceImpl employeeService;

    public BankDetailsServiceImpl(BankDetailsRepo bankDetailsRepo, EmployeeServiceImpl employeeService) {
        this.bankDetailsRepo = bankDetailsRepo;
        this.employeeService = employeeService;
    }

    @Override
    public BankDetailsDTO saveBankDetails(BankDetailsDTO bankDetailsDTO, Long empId)
            throws EmployeeNotFoundException, AlreadyExistException {
        Employee employee = employeeService.getEmployeeById(empId);
        BankDetails bankDetails = new BankDetails();
        BeanUtils.copyProperties(bankDetailsDTO, bankDetails);
        BankDetails existingBankDetails = bankDetailsRepo.findByAccountNumber(bankDetailsDTO.getAccountNumber());

        if(existingBankDetails != null) {
            throw new AlreadyExistException("Employee already exist");
        }

        bankDetails.setEmployee(employee);
        return mapToBankDetails(bankDetailsRepo.save(bankDetails));
    }

    public BankDetailsDTO mapToBankDetails(BankDetails bankDetails) {
        return BankDetailsDTO.builder()
                .bankName(bankDetails.getBankName())
                .accountNumber(bankDetails.getAccountNumber())
                .build();
    }
}
