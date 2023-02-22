package com.devlon.payroll.dto;

import com.devlon.payroll.entity.Employee;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankDetailsDTO {
    private Long bankDetailsId;
    private String bankName;
    private String accountNumber;
    private Employee employee;
}
