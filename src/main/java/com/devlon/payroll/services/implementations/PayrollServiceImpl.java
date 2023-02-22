package com.devlon.payroll.services.implementations;

import com.devlon.payroll.dto.EmployeeDTO;
import com.devlon.payroll.dto.PayrollDTO;
import com.devlon.payroll.entity.Employee;
import com.devlon.payroll.entity.Payroll;
import com.devlon.payroll.exception.EmployeeNotFoundException;
import com.devlon.payroll.repository.PayrollRepo;
import com.devlon.payroll.services.PayrollService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PayrollServiceImpl implements PayrollService {
    private final PayrollRepo payrollRepo;
    private final EmployeeServiceImpl employeeService;

    public PayrollServiceImpl(PayrollRepo payrollRepo, EmployeeServiceImpl employeeService) {
        this.payrollRepo = payrollRepo;
        this.employeeService = employeeService;
    }

    @Override
    public PayrollDTO addPayroll(PayrollDTO payrollDTO, Long empId) throws EmployeeNotFoundException {
        Employee employee;
        try {
            employee = employeeService.getEmployeeById(empId);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException("Employee not found");
        }

        Payroll payroll = new Payroll();
        BeanUtils.copyProperties(payrollDTO, payroll);
        payroll.setEmployee(employee);

        return mapToPayrollDTO(payrollRepo.save(payroll));
    }

    @Override
    public Payroll getPayrollByEmpId(Long empId) throws EmployeeNotFoundException {
        Payroll payroll = payrollRepo.findByEmpId(empId);
        if(payroll == null) {
            throw new EmployeeNotFoundException("Payroll is empty");
        }
        return payroll;
    }

    public PayrollDTO mapToPayrollDTO(Payroll payroll) {
        return PayrollDTO.builder()
                .payrollCycle(payroll.getPayrollCycle())
                .build();
    }
}
