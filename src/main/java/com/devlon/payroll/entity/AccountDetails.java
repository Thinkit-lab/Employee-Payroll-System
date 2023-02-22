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
public class AccountDetails implements Serializable {
    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Long accountDetailsId;
    private String accountType;
    private String accountNumber;
    @OneToOne
    @JoinColumn(name = "empId",referencedColumnName = "empId")
    private Employee employee;
}
