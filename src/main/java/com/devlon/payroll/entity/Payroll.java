package com.devlon.payroll.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Payroll implements Serializable {
    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Long payRollId;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date payrollCycle;
    @OneToOne
    @JoinColumn(name = "empId", referencedColumnName = "empId")
    private Employee employee;
    @OneToOne(mappedBy = "payroll")
    private Approval approval;
}
