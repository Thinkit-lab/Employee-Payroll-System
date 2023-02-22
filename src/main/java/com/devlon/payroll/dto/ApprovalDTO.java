package com.devlon.payroll.dto;

import com.devlon.payroll.entity.Payroll;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApprovalDTO {
    private Long approvalId;
    private String reviewer;
    private boolean approved;
    private Payroll payroll;
}
