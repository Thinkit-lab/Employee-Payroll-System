package com.devlon.payroll.services;

import com.devlon.payroll.dto.ApprovalDTO;
import com.devlon.payroll.exception.EmployeeNotFoundException;

public interface ApprovalService {
    ApprovalDTO saveApproval(ApprovalDTO approvalDTO, Long empId) throws EmployeeNotFoundException;
}
