package com.devlon.payroll.controller;

import com.devlon.payroll.dto.EmployeeDTO;
import com.devlon.payroll.entity.Employee;
import com.devlon.payroll.exception.AlreadyExistException;
import com.devlon.payroll.services.implementations.EmployeeServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@Log4j2
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/")
//    @PreAuthorize("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_COMPENSATION_ADMIN')")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) throws AlreadyExistException {
        log.info("Saving Employee");
        EmployeeDTO response = employeeService.saveEmployee(employeeDTO);
        log.info("Success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_COMPENSATION_ADMIN')")
    public ResponseEntity<?> allEmployee() throws AlreadyExistException {
        log.info("Saving Employee");
        List<EmployeeDTO> response = employeeService.getAllEmployee();
        log.info("Success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
