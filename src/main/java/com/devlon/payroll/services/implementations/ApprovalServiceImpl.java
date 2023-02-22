package com.devlon.payroll.services.implementations;

import com.devlon.payroll.dto.ApprovalDTO;
import com.devlon.payroll.dto.PayrollDTO;
import com.devlon.payroll.entity.Approval;
import com.devlon.payroll.entity.Employee;
import com.devlon.payroll.entity.Payroll;
import com.devlon.payroll.exception.EmployeeNotFoundException;
import com.devlon.payroll.repository.ApprovalRepo;
import com.devlon.payroll.services.ApprovalService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ApprovalServiceImpl implements ApprovalService {
    private final ApprovalRepo approvalRepo;
    private final EmployeeServiceImpl employeeService;
    private final PayrollServiceImpl payrollService;

    public ApprovalServiceImpl(ApprovalRepo approvalRepo, EmployeeServiceImpl employeeService, PayrollServiceImpl payrollService) {
        this.approvalRepo = approvalRepo;
        this.employeeService = employeeService;
        this.payrollService = payrollService;
    }

    @Override
    public ApprovalDTO saveApproval(ApprovalDTO approvalDTO, Long empId) throws EmployeeNotFoundException {
        Approval approval = new Approval();
        BeanUtils.copyProperties(approvalDTO, approval);

        Payroll payroll = payrollService.getPayrollByEmpId(empId);
        approval.setPayroll(payroll);

        Approval responseApproval = approvalRepo.save(approval);

        return mapToApprovalDTO(responseApproval);
    }

    public ApprovalDTO mapToApprovalDTO(Approval approval) {
        return ApprovalDTO.builder()
                .approved(approval.isApproved())
                .reviewer(approval.getReviewer())
                .build();
    }
}
