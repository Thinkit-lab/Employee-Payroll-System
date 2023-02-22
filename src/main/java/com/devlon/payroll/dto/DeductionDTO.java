package com.devlon.payroll.dto;

import com.devlon.payroll.entity.Employee;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeductionDTO {
    private Long deductionId;
    private String type;
    private double amount;
    private Employee employee;
}
