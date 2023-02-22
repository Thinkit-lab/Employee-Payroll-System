package com.devlon.payroll.repository;

import com.devlon.payroll.entity.Approval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRepo extends JpaRepository<Approval, Long> {
}
