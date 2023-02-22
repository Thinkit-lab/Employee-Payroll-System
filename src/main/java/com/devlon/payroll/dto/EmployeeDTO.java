package com.devlon.payroll.dto;

import com.devlon.payroll.entity.AccountDetails;
import com.devlon.payroll.entity.BankDetails;
import com.devlon.payroll.entity.Deduction;
import com.devlon.payroll.security.ApplicationUserRole;
import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO implements Serializable {
    private Long empId;
    private String name;
    private String email;
    private String password;
    private ApplicationUserRole role;
    private double grossPay;
    private double netPay;
    private boolean enabled = false;
}
