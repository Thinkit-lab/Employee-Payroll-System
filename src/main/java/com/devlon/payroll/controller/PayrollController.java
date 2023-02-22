package com.devlon.payroll.controller;

import com.devlon.payroll.dto.PayrollDTO;
import com.devlon.payroll.entity.Payroll;
import com.devlon.payroll.exception.EmployeeNotFoundException;
import com.devlon.payroll.repository.PayrollRepo;
import com.devlon.payroll.services.PayrollService;
import com.devlon.payroll.services.implementations.PayrollServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@Log4j2
public class PayrollController {
    private final PayrollServiceImpl payrollService;

    public PayrollController(PayrollServiceImpl payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping("/employee/payroll/{empId}")
    public ResponseEntity<PayrollDTO> addPayroll(@PathVariable Long empId, @RequestBody PayrollDTO payrollDTO)
            throws EmployeeNotFoundException {
       log.info("Endpoint hit");
       PayrollDTO response = payrollService.addPayroll(payrollDTO, empId);
       log.info("Payroll Added");
       return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


}
