package com.devlon.payroll.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payslip implements Serializable {
    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Long payslipId;
    private double grossPay;
    private double netPay;
    private double deductionAmount;
    private Date dateCreated;
    @OneToOne
    @JoinColumn(name = "empId", referencedColumnName = "empId")
    private Employee employee;
    @OneToOne
    @JoinColumn(name = "payRollId", referencedColumnName = "payRollId")
    private Payroll payroll;
    @OneToOne
    @JoinColumn(name = "deductionId", referencedColumnName = "deductionId")
    private Deduction deduction;
}
