package com.devlon.payroll.controller;

import com.devlon.payroll.dto.BankDetailsDTO;
import com.devlon.payroll.entity.BankDetails;
import com.devlon.payroll.exception.AlreadyExistException;
import com.devlon.payroll.exception.EmployeeNotFoundException;
import com.devlon.payroll.services.implementations.BankDetailsServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@Log4j2
public class BankDetailsController {
    private final BankDetailsServiceImpl bankDetailsService;

    public BankDetailsController(BankDetailsServiceImpl bankDetailsService) {
        this.bankDetailsService = bankDetailsService;
    }

    @PostMapping("/employee/bank-details/{empId}")
    public ResponseEntity<BankDetailsDTO> saveBankDetails(@RequestBody BankDetailsDTO bankDetailsDTO, @PathVariable Long empId) throws EmployeeNotFoundException, AlreadyExistException {
        log.info("Saving bank details");
        BankDetailsDTO response = bankDetailsService.saveBankDetails(bankDetailsDTO, empId);
        log.info("Bank Details Saved");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
