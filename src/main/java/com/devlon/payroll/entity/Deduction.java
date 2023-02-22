package com.devlon.payroll.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Deduction implements Serializable {
    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Long deductionId;
    private String type;
    private double amount;
    @ManyToOne()
    @JoinColumn(name = "empId",referencedColumnName = "empId")
    private Employee employee;
}
