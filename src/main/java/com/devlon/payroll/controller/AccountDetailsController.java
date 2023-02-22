package com.devlon.payroll.controller;

import com.devlon.payroll.dto.AccountDetailsDTO;
import com.devlon.payroll.dto.EmployeeDTO;
import com.devlon.payroll.entity.AccountDetails;
import com.devlon.payroll.entity.Employee;
import com.devlon.payroll.exception.AlreadyExistException;
import com.devlon.payroll.exception.EmployeeNotFoundException;
import com.devlon.payroll.services.AccountDetailsService;
import com.devlon.payroll.services.implementations.AccountDetailsServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@Log4j2
public class AccountDetailsController {
    private AccountDetailsServiceImpl accountDetailsService;

    public AccountDetailsController(AccountDetailsServiceImpl accountDetailsService) {
        this.accountDetailsService = accountDetailsService;
    }

    @PostMapping("/employee/account/{empId}")
    public ResponseEntity<?> createAccount(@RequestBody AccountDetailsDTO accountDetailsDTO,
                                                       @PathVariable Long empId) throws EmployeeNotFoundException, AlreadyExistException {
        log.info("Saving Employee Account Details");
        AccountDetailsDTO response = accountDetailsService.saveAccount(empId, accountDetailsDTO);
        log.info("Account Created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
