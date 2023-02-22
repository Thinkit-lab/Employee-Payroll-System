package com.devlon.payroll.entity;

import com.devlon.payroll.security.ApplicationUserRole;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee implements Serializable {
    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Long empId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private ApplicationUserRole role;
    @Column(name = "gross_pay")
    private double grossPay;
    @Column(name = "net_pay")
    private double netPay;
    @Column(name = "enabled")
    private boolean enabled = false;
    @OneToOne(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private BankDetails bankDetails;
    @OneToOne(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private AccountDetails accountDetails;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<Deduction> deductions;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
