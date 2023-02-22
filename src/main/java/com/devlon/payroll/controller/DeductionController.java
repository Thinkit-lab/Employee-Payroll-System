package com.devlon.payroll.controller;

import com.devlon.payroll.dto.DeductionDTO;
import com.devlon.payroll.entity.Deduction;
import com.devlon.payroll.exception.EmployeeNotFoundException;
import com.devlon.payroll.services.DeductionService;
import com.devlon.payroll.services.implementations.DeductionServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/")
@Log4j2
public class DeductionController {

    private final DeductionServiceImpl deductionService;

    public DeductionController(DeductionServiceImpl deductionService) {
        this.deductionService = deductionService;
    }

    @PostMapping("/employee/deduction/{empId}")
//    @PreAuthorize("hasAuthority('deduction:write')")
    @PreAuthorize("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_COMPENSATION_ADMIN')")
    public ResponseEntity<DeductionDTO> deduction(@RequestBody DeductionDTO deductionDTO, @PathVariable Long empId) throws EmployeeNotFoundException {
        log.info("Endpoint Hit");
        DeductionDTO response = deductionService.saveDeduction(deductionDTO, empId);
        log.info("Deduction Saved");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
