package com.devlon.payroll.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Approval implements Serializable {
    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Long approvalId;
    private String reviewer;
    private boolean approved;
    @OneToOne
    @JoinColumn(name = "payRollId", referencedColumnName = "payRollId")
    private Payroll payroll;
}
