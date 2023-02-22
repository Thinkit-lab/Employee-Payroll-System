package com.devlon.payroll.dto;

import com.devlon.payroll.entity.Approval;
import com.devlon.payroll.entity.Employee;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayrollDTO {
    private Long payRollId;
    private Date payrollCycle;
    private Employee employee;
    private Approval approval;
}
