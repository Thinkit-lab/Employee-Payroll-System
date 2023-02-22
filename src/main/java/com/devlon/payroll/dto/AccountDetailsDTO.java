package com.devlon.payroll.dto;

import com.devlon.payroll.entity.Employee;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDetailsDTO implements Serializable {
    private Long accountDetailsId;
    private String accountType;
    private String accountNumber;
    private Employee employee;
}
