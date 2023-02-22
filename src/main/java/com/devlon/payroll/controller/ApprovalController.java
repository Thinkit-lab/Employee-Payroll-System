package com.devlon.payroll.controller;

import com.devlon.payroll.dto.ApprovalDTO;
import com.devlon.payroll.exception.EmployeeNotFoundException;
import com.devlon.payroll.services.ApprovalService;
import com.devlon.payroll.services.implementations.ApprovalServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@Log4j2
public class ApprovalController {
    private ApprovalServiceImpl approvalService;

    public ApprovalController(ApprovalServiceImpl approvalService) {
        this.approvalService = approvalService;
    }

    @PostMapping("/employee/approval/{empId}")
    public ResponseEntity<ApprovalDTO> getApproval(@RequestBody ApprovalDTO approvalDTO, @PathVariable Long empId) throws EmployeeNotFoundException {
        log.info("Endpoint hit");
        ApprovalDTO response = approvalService.saveApproval(approvalDTO, empId);
        log.info("Approval Saved");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
