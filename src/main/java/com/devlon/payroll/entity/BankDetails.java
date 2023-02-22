package com.devlon.payroll.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankDetails implements Serializable {
    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Long bankDetailsId;
    private String bankName;
    private String accountNumber;
    @OneToOne
    @JoinColumn(name = "empId",referencedColumnName = "empId")
    private Employee employee;
}
